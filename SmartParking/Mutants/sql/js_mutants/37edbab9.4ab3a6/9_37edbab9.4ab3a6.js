msg.request = msg.payload
var query = "SELECT COUNT(*) AS numparks FROM smartparking.parks WHERE type = '"+msg.request.type+"' OR status = 0"
msg.payload = [
    {'query' : query,
    'output': true}
    ]
return msg;