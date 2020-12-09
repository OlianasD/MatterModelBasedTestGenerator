msg.request = msg.payload
msg.payload = [
    {
           'query' : ""+msg.request.type+"' AND status = 0",
        'output' : true
    }
]
//return msg;