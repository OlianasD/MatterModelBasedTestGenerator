node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' AND (1=1)"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;