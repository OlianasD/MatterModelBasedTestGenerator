   msg.payload= ""
context.global.set('status', 2)
context.global.set('last', [])
context.global.set('count', 0)
context.global.set('discard', 5)
node.log('next cloud status: 2')
//return msg