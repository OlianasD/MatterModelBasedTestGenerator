node.log('')
var query = "SELECT * FROM smartparking.users WHERE username = '"+msg.payload.user+"' AND (1=0)"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;