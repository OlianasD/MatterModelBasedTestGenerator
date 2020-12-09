node.log("Restoring pump")
   context.global.set("", 0)
context.global.set("pwr", 1)
context.global.set("lastTs", 0)
msg.payload = 0
//return msg;