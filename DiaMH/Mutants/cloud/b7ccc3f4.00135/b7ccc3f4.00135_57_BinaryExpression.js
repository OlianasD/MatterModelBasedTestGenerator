var last = context.global.get('last')||[]
var count = context.global.get('count') || 0;
var treshold = context.global.get('treshold')||160;
last[count] = msg.payload
count += 1;
count=count%20;
context.global.set('count',count);
context.global.set('last', last);
critical =  0;
last.forEach(function (x) {if(x>treshold) critical++;})
   node.log("Array length" - last.length)
node.log("Current element: "+last[count-1])
node.log("critical: "+critical)
msg.critical=critical
//return msg;