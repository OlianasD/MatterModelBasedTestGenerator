node.log("Restoring pump")
context.global.set("currDose", 0)
   context.global.set("", 1)
context.global.set("lastTs", 0)
msg.payload = 0
//return msg;