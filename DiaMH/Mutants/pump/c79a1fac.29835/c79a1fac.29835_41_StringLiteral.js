node.log("received ping")
   node.log(context.global.get(""))
if(context.global.get("pwr") == 1) {
    node.log("replying ping")
    msg.payload="{\"pong\" : 1}\n"
    //return msg;
}