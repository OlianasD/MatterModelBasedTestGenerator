var ts = (new Date).getTime()
msg.payload = "{\"insuline\" : 1, \"timestamp\": "+ts+"}"
context.global.set('discard', 5)
context.global.set('last', [])
   context.global.set("", 0)
//return msg