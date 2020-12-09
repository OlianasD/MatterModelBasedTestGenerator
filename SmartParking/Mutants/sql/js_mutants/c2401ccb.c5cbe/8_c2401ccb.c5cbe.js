node.log('')
var query = "SELECT * FROM smartparking.users WHERE (1=0) AND psw = '"+msg.payload.psw+"'"
msg.payload = [
    { 'query' : query,
        'output' : true
    }
]
return msg;