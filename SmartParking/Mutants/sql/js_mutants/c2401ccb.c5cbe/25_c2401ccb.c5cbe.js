node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' AND psw = '"+msg.payload.user+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;