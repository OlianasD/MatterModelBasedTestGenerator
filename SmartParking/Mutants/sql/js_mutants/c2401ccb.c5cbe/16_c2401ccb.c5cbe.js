node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' AND users.username = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;