node.log('')
var query = "SELECT * FROM smartparking.users WHERE (1=1) AND psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;