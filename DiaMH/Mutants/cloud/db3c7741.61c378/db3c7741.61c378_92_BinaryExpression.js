var count = msg.count
var last = context.global.get('last')
var treshold = context.global.get('treshold')||160;
last[count] = msg.payload
count += 1;
critical =  0;
   last.forEach(function (x) {if(x <= treshold) critical++;})
node.log("Array length"+last.length)
node.log("Current element: "+last[count-1])
node.log("critical: "+critical)
msg.critical=critical
context.global.set('count',count);
context.global.set('last', last);
node.log('msg.stat: '+msg.stat)
if(count>=20) {
    //return msg;
}