msg.payload= "{\"alarm\" : 1}"
   context.global.set("", 2)
context.global.set('last', [])
context.global.set('count', 0)
context.global.set('discard', 5)
node.log('next cloud status: 2')
//return msg