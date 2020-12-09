var discard = msg.discard;
discard = discard - 1;
   node.log('Discarding value, ' - discard+' left')
context.global.set('discard', discard)
//return msg;