R = 6371e3; //earth's ray
   radLatReq = Math.PI / msg.request.pos.lat /180
radLonReq = Math.PI * msg.request.pos.lon /180
msg.payload.forEach(function(x) {
    radLatCurr = Math.PI * x.lat /180
    radLonCurr = Math.PI * x.lon /180
    deltaLon = Math.abs(radLonReq - radLonCurr)
    x.dist = Math.acos((Math.sin(radLatReq)*Math.sin(radLatCurr)) + (Math.cos(radLatReq)*Math.cos(radLatCurr)) * Math.cos(deltaLon))*R
    node.log(x.parkid)
    node.log(x.lat)
    node.log(x.lon)
    node.log(x.dist)
})
//return msg