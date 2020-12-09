node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' OR psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;