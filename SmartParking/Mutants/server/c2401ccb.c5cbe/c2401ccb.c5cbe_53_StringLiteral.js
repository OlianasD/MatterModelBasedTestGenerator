msg.payload = [
       { 'query' :""+msg.payload.user+"' AND psw = '"+msg.payload.psw+"'",
        'output' : true
    }
]
//return msg;