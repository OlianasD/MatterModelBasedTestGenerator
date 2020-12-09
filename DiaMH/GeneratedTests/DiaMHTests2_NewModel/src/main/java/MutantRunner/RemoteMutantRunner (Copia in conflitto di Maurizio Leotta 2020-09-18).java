package MutantRunner;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import DiaMHTestsMaven.DiaMHTests.DiaMHMinimizedTestClass;
import DiaMHTestsMaven.DiaMHTests.DiaMHTestClass;



public class RemoteMutantRunner {
	
	
	private static final String resPath = "C:/Users/olly1/Dropbox/Tirocinio Dario/tools/estrazione_mutanti_node-red/diamh_tesi/DiaMH_QUATIC2020/results/";
	private static final String timesPath = "C:/Users/olly1/Dropbox/Tirocinio Dario/tools/estrazione_mutanti_node-red/diamh_tesi/DiaMH_QUATIC2020/times/times.csv";
	public static NodeREDWrapper nr;
	
	
	public static String[] getTestNames(String fullClassName, int numTests) {
		String[] tests = new String[numTests];
		for(int i=0; i<numTests; i++) {
			tests[i] = "test_"+(i+1)+"("+fullClassName+")";
		}
		return tests;
	}
	
	public static String generateHeader(int numTests) {
		StringBuilder res = new StringBuilder();
		for(int i=1; i<=numTests; i++) {
			res.append("test"+i+",");
		}
		res.deleteCharAt(res.length()-1);
		res.append("\n");
		return res.toString();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String host = "192.168.1.161";
		String times = "mutant,time\n";
		
		//List<Result> res = new ArrayList<>();
		HashMap<String, Integer[]> results = new HashMap<>();
		nr = new NodeREDWrapper(host);
		String[] muts = {"cloud/c2845047.0dcb4_66_ConditionalExpression.js.json", "cloud/c2845047.0dcb4_67_StringLiteral.js.json", "cloud/c2845047.0dcb4_71_StringLiteral.js.json", "cloud/c2845047.0dcb4_74_StringLiteral.js.json", "cloud/c8ab8de2.b4d91_77_StringLiteral.js.json"};
		Class<?> testClass = null;
		int numTests = 0;
		testClass = DiaMHMinimizedTestClass.class;
		numTests = 8;
		for(int i = 0; i<muts.length; i++) {
			String[] testNames = getTestNames(testClass.getName(), numTests);
			String header = generateHeader(numTests);
			nr.start(muts[i]);

			Thread.sleep(20000);
			JUnitCore junit = new JUnitCore();
			junit.addListener(new TextListener(System.out));
			long start = System.currentTimeMillis();
			Result result = junit.run(testClass);
			long end = System.currentTimeMillis();
			nr.stop();
			Integer[] res = ResultsManager.getMutantResults(result, testNames);
			ResultsManager.saveMutant(muts[i], res, header, resPath, i);
			float duration = (end-start)/(float)1000;
			times += muts[i]+","+duration+"\n";
			ResultsManager.saveTimes(times, timesPath);
			Thread.sleep(10000);
		}

		
	}


	
}
