   if(msg.payload.length === null || true) {
    msg.payload="{\"LoginResult\": false}"
}
else {
    msg.payload = "{\"LoginResult\": true}"
}
//return msg;