node.log(msg.payload)
   var status=false
var discard=context.global.get('discard')||0
node.log('Current cloud status: '+status.toString())
msg['stat'] = status
msg['discard'] = discard
//return msg