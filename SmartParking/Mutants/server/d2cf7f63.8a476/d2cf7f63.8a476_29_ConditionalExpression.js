   if(true || msg.payload.length === 0) {
    msg.payload="{\"LoginResult\": false}"
}
else {
    msg.payload = "{\"LoginResult\": true}"
}
//return msg;