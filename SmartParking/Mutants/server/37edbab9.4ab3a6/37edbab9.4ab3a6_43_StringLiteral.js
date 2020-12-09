msg.request = msg.payload
msg.payload = [
       {'query' : "SELECT COUNT(*) as numparks FROM smartparking.parks WHERE type = '"+msg.request.type+"", 'output': true}
    ]
//return msg;