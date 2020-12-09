node.log('')
var query = "SELECT * FROM smartparking.users WHERE psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;