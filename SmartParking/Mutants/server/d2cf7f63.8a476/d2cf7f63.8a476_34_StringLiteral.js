if(msg.payload.length === null || msg.payload.length === 0) {
       msg.payload=""
}
else {
    msg.payload = "{\"LoginResult\": true}"
}
//return msg;