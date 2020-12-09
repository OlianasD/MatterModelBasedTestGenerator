   if(msg.payload.length === null || msg.payload.length === 0) {}
else {
    msg.payload = "{\"LoginResult\": true}"
}
//return msg;