import json
from unittest import TestCase
from main import get_paths, print_path
from pathgen import evaluate_guards


class Tests(TestCase):

    @classmethod
    def setup_python(self):
        self.xmlgraph = '../statemachines/santander_allself.scxml'
        self.lang = '-p'
        self.config_file = 'santander_config.json'

    @classmethod
    def setup_java(self):
        self.xmlgraph = '../../statemachines/diamh_newmodel.scxml'
        self.lang ='-j'
        self.config_file = 'config/diamh/diamh_newmodel_config.json'
        self.impl_file = 'config/diamh/diamh_implementations.json'

    @classmethod
    def setUpClass(self):
        self.setup_java()
        app_name = 'diamh'
        paths, edges, init_state, named_states = get_paths('diamh_newmodel.scxml', self.lang, 'DiaMH.java', app_name)
        self.paths = paths
        self.edges = edges
        self.init_state = init_state
        self.named_states = named_states
        with open('config/' + app_name + '/mocks_init.json', 'r') as f:
            self.mocks_init = json.load(f)




    def test_transition_coverage(self):
        self.assertTrue(check_transition_coverage(self.edges, self.paths))

    def test_correctness(self):
        self.assertTrue(check_paths_correctness(self.paths))

    def test_same_transition(self):
        self.assertTrue(check_last_transition(self.paths))

    def test_all_starts_in_init(self):
        self.assertTrue(all_starts_with_init(self.paths, self.init_state))

    def test_executability(self):
        self.assertTrue(check_exec_paths(self.paths, self.named_states, self.mocks_init))


def check_transition_coverage(edges, paths):
    rv = True
    for edge in edges:
        found = False
        for path in paths:
            if (edge in path):
                found = True
                break
        if not found:
            print('Missing edge: ' + str(edge))
            rv =  False
    return rv


def check_paths_correctness(paths):
    for path in paths:
        for i in range(1, len(path) - 1):
            if (path[i - 1][1] != path[i][0]):
                print('Wrong path: ')
                print_path(path)
                return False

    return True


'''
def check_included(partial_paths):
    sp = sorted(partial_paths, key=len)
    paths = []
    for i in range(0, len(sp)):
        addthis = True
        for p1 in sp[i:]:
            for j in range(0, len(p1) - len(sp[i])):
                if ((p1[j:j + len(sp[i])] == sp[i]) or (p1[-len(sp[i]):] == sp[i])):
                    print('Included paths:\n' + str(p1) + '\n' + str(sp[i]))
                    return True
    return False
'''


def check_last_transition(paths):
    for path in paths:
        for pth in paths:
            if ((path != pth) and (path[len(path) - 1] == pth[len(pth) - 1])):
                print('Two paths with same last transition:\n' + str(path) + '\n' + str(pth))
                return False

    return True


def all_starts_with_init(paths, init):
    for path in paths:
        if (path[0][0] != init):
            print(str(path) + ' not starting in ' + init)
            return False
    return True


def check_exec_paths(paths, named_states, mocks_init):
    rv = True
    for path in paths:
        if (not check_executability(path, named_states, mocks_init)):
            print('Non executable path:')
            print_path(path)
            rv = False
    return rv


def check_executability(path, named_states, mocks_init):
    context = {}
    for statement in mocks_init:
        exec(statement, {}, context)
    for edge in path:
        edgeinfo = json.loads(edge[2].replace('\"','\\"').replace('\'', '\"'))

        try:
            if (not evaluate_guards(edgeinfo['guard'], context)):
                # print('Non executable path at edge'+str(edgeinfo)+':\n\n'+str(path))
                return False
            if (edgeinfo['event']['type'] == 'assignment' or edgeinfo['event']['type'] == 'initialization' or edgeinfo['event']['type'] == 'call'):
                # print('!!! RUNNING EVENT ' + edgeinfo['event']['code'])
                exec(edgeinfo['event']['code'], {}, context)
            if ('action' in edgeinfo):
                for a in edgeinfo['action']:
                    if (a['type'] == 'assignment' or a['type'] == 'initialization' or a['type'] == 'call'):
                        # print('!!! RUNNING ACTION ' + a['code'])
                        if ('py_code' in a):
                            exec(a['py_code'], {}, context)
                        else:
                            exec(a['code'], {}, context)
            # se lo stato target ha entry actions
            if (named_states[edge[1]].attrib['entryAction']):
                for ea in named_states[edge[1]].attrib['entryAction']:
                    if (ea['type'] == 'assignment' or ea['type'] == 'initialization' or ea['type'] ==  'call'):
                        # print('!!! RUNNING ENTRY ACTION ' + ea['code'])
                        exec(ea['code'], {}, context)
        except Exception as exc:
            print('Non executable path (threw exception) at edge ' + str(edgeinfo) + ':\n\n' + str(path))
            return False
    return True