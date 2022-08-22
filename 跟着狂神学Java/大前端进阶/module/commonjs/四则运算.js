//工具类
const sum = function(a,b){
    return a+b;
}
const sub = function(a,b){
    return a-b;
}
const mul = function(a,b){
    return a*b;
}
const di = function(a,b){
    return a/b;
}
//导出给别人用好了
module.exports = {
    sum,
    sub,
    mul,
    di
}