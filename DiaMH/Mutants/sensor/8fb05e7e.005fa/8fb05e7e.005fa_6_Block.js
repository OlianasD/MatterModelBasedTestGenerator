var max_tresh = 320
var min_tresh = 90
var val = -1

   if(msg.payload['kind'] == 'over') {}
else {
    node.log("Sending under")
    val = Math.floor(Math.random() * (msg.payload.treshold - min_tresh+1)) + min_tresh;
}
    

msg.payload=val.toString()+'\n'
//return msg;