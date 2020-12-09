   if(msg.payload.length === null || false) {
    msg.payload="{\"LoginResult\": false}"
}
else {
    msg.payload = "{\"LoginResult\": true}"
}
//return msg;