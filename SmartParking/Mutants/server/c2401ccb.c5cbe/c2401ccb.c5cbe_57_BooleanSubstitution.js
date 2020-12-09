msg.payload = [
    { 'query' :"SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' AND psw = '"+msg.payload.psw+"'",
           'output' : false
    }
]
//return msg;