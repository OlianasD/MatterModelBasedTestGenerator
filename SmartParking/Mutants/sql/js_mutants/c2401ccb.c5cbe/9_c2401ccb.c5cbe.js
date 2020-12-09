node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = users.psw AND psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;