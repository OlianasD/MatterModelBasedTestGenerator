node.log(msg.payload)
var status=context.global.get('status')||0
var discard=context.global.get('discard')||0
   node.log(""+status.toString())
msg['stat'] = status
msg['discard'] = discard
//return msg