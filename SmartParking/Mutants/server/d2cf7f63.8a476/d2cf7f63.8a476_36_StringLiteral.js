if(msg.payload.length === null || msg.payload.length === 0) {
    msg.payload="{\"LoginResult\": false}"
}
else {
       msg.payload = ""
}
//return msg;