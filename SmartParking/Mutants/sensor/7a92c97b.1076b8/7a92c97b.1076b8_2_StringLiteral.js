node.log(msg.payload.parkid)
node.log(msg.payload.status)
msg.payload = [
    {
           "" : "UPDATE smartparking.parks SET status = "+msg.payload.status+" WHERE parkid = "+msg.payload.parkid,
        'output' : true
    }
    ]
//return msg;