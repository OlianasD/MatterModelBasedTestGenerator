if(context.global.get("pwr") == 1) {
    var currDose = context.global.get('currDose') || 0
    node.log("INSULINE PUMP: received"+msg.payload.ins,+" timestamp "+msg.payload.ts);
    var lastTs = context.global.get("lastTs")||0
       if(true) {
        currDose += msg.payload.ins
        context.global.set("currDose", currDose)
        context.global.set("lastTs", msg.payload.ts)
    }
    msg.payload=currDose.toString()+'\n'
    //return msg;
}