msg.request = msg.payload
msg.payload = [
    {
           'query' : "SELECT * FROM smartparking.parks WHERE type = '"+msg.request.type+"",
        'output' : true
    }
]
//return msg;