function add0(m){return m<10?'0'+m:m }
function dateYMDFormat(shijianchuo) {
    //shijianchuo是整数，否则要parseInt转换
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours(); //获取时，
    var mm = time.getMinutes(); //分
    var s = time.getSeconds(); //秒
    return y+'-'+add0(m)+'-'+add0(d)+" "+add0(h)+":"+add0(mm)+":"+add0(s) ;
}
