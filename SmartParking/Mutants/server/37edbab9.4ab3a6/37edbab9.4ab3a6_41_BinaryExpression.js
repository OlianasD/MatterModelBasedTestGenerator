msg.request = msg.payload
msg.payload = [
       {'query' : "SELECT COUNT(*) as numparks FROM smartparking.parks WHERE type = '" - msg.request.type+"' AND status = 0", 'output': true}
    ]
//return msg;