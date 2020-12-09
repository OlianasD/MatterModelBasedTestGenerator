context.global.set('status', 0)
node.log('next cloud status: 0')
if(msg.stat !== 0) {
       context.global.set("", 0)    //return msg;
}

