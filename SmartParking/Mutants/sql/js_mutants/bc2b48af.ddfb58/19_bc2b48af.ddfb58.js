msg.request = msg.payload
var query = "SELECT * FROM smartparking.parks WHERE type = '"+msg.request.type+"' AND parkid = 0"
msg.payload = [
    {
        'query' : query,
        'output' : true
    }
]
return msg;