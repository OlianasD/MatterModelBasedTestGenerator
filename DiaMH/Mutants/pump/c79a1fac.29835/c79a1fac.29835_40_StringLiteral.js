   node.log("")
node.log(context.global.get("pwr"))
if(context.global.get("pwr") == 1) {
    node.log("replying ping")
    msg.payload="{\"pong\" : 1}\n"
    //return msg;
}