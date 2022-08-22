//1,导入mysql依赖
var mysql = require('mysql');
//2,创建一个mysql的connection对象,配置数据库连接的信息
var connection = mysql.createConnection({
    host:"127.0.0.1",
    user:"root",
    port:3306,
    password:"123456",
    database:"java-test"
});
//4,开辟连接
connection.connect();
//5,执行crud
connection.query("select * from tb_user",function(error,result,fields){
   //如果错误直接抛出
    if(error)throw error;
   //查询成功
   console.log("results=",result);
});
//6，关闭连接
connection.end();
//7，运行node db.js 查看效果