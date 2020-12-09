msg.payload = [
       { 'query' :"SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+""+msg.payload.psw+"'",
        'output' : true
    }
]
//return msg;