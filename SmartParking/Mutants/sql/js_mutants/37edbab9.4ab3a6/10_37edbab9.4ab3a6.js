msg.request = msg.payload
var query = "SELECT COUNT(*) AS numparks FROM smartparking.parks WHERE (1=1)"
msg.payload = [
    {'query' : query,
    'output': true}
    ]
return msg;