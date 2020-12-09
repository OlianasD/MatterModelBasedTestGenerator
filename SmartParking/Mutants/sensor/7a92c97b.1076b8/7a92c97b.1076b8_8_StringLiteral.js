node.log(msg.payload.parkid)
node.log(msg.payload.status)
msg.payload = [
    {
        'query' : "UPDATE smartparking.parks SET status = "+msg.payload.status+" WHERE parkid = "+msg.payload.parkid,
           "" : true
    }
    ]
//return msg;