msg.request = msg.payload
var query = "SELECT * FROM smartparking.parks WHERE (1=0) AND status = 0"
msg.payload = [
    {
        'query' : query,
        'output' : true
    }
]
return msg;