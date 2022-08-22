//导入模块是require,就类似于 import java.io
const http = require('http');

//1,创建一个httpserver服务
http.createServer(function(request,response){
    //浏览器怎么认识hello server
    response.writeHead(200,{'Content-type':'text/plain'});//告诉浏览器以text-plain取解析hello server这段数据
    //给浏览器输出内容
    response.end("<strong>nodejs是服务端语言</strong>");
}).listen(8888);
console.log("你启动的服务是http://localhost:8888");
//2,监听端口8888
//3,启动运行服务 node httpseerver.js
//4,在浏览器访问http://localhost:8080