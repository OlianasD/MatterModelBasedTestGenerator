node.log('next cloud status: 1')
   node.log(""+msg.stat.toString())
context.global.set("status", 1)
if(msg.stat != 2) {
    //return msg;
} else{
    return [msg, {payload:"off"}]
}