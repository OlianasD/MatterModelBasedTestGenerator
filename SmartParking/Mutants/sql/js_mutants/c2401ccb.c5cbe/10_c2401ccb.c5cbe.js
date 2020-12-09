node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.psw+"' AND psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;