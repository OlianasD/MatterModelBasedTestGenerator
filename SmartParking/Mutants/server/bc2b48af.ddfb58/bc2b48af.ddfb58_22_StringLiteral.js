msg.request = msg.payload
msg.payload = [
    {
        'query' : "SELECT * FROM smartparking.parks WHERE type = '"+msg.request.type+"' AND status = 0",
           "" : true
    }
]
//return msg;