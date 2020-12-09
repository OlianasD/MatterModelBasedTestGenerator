var discard = msg.discard;
discard = discard - 1;
   node.log(""+discard+' left')
context.global.set('discard', discard)
//return msg;