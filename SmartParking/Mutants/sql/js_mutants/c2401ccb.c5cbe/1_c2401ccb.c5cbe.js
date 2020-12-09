node.log('')
var query = "SELECT * FROM smartparking.users WHERE users.psw = '"+msg.payload.user+"' AND psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;