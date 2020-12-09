if(context.global.get("pwr") == 1) {
       var currDose = false
    node.log("INSULINE PUMP: received"+msg.payload.ins,+" timestamp "+msg.payload.ts);
    var lastTs = context.global.get("lastTs")||0
    if(lastTs == 0 || msg.payload.ts != lastTs) {
        currDose += msg.payload.ins
        context.global.set("currDose", currDose)
        context.global.set("lastTs", msg.payload.ts)
    }
    msg.payload=currDose.toString()+'\n'
    //return msg;
}