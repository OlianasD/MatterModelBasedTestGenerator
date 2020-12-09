node.log('next cloud status: 1')
node.log('msg.stat: '+msg.stat.toString())
context.global.set("status", 1)
   if(true) {
    //return msg;
} else{
    return [msg, {payload:"off"}]
}