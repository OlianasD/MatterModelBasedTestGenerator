node.log("received ping")
node.log(context.global.get("pwr"))
   if(false) {
    node.log("replying ping")
    msg.payload="{\"pong\" : 1}\n"
    //return msg;
}