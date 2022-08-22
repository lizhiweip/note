1,攻击篇
   一，用xss脚本攻击
    （1）存储型攻击（Stored XSS）
      -恶意脚本被存在数据库中
      -访问页面->读数据->被攻击
      -危害最大，对全部用户可见
    （2）反射型攻击（Reflected XSS）
      -不涉及数据库
      -从URL上攻击
       例如：
         服务端代码：public async render(ctx) {
            const {param} = ctx.query;
            ctx.status = 200;
            ctx.body = `<div>${param}</div>`
         }
         攻击请求：host/path/?param=<script>alert('123')</script>

              (恶意脚本)
         Server--------->Browser

    （3）DOM-based XSS
      -不需要服务器的参与
      -恶意攻击的发起+执行，全在浏览器完成
        const content = new URL(location.href).searchParams.get("param");
        const div = document.creatElement("div");
        //恶意脚本注入
        div.innerHTML = content;
        document.body.append(div);

        Browser--------->恶意脚本
               <--------

    二，用CSRF攻击
      -在用户不知情的前提下
      -利用用户权限（cookie）
      -构造指定HTTP请求，窃取或修改用户敏感信息
        例子：
           1，用户没有访问银行页面
           2，银行页面中的特定接口被请求            (请求银行转账的接口，另一个域名)
           3，请求执行成功  -------------->恶意页面------------------------------>银行服务器（有cookie的请求，合法用户的请求）
                                                 <------------------------------
                                                            (执行成功)

    （1）CSRF---GET
      <a href="http://bank.com/transfer?to=hacker&amount=100">点我抽奖</a>
      或者
      <img style="display:none;" src="http://bank.com/transfer?to=hacker&amount=100"/>

    （2）CSRF---POST
    隐藏域表单
    <form action="http://bank/transfer_ton_of_money" method="POST">
      <input name="amount" value=100000000 type="hidden"/>
      <input name="to" value="hacker" type="hidden"/>
    </form>

   三，Injection
    （1）SQLInjection
            （SQL参数恶意注入）       （运行恶意SQL）
         请求----------------->Servser------------->获取数据（修改，删除数据）

    （2）命令注入

    （3）修改nginxpages,
        把网站流量全部转发到第三方网站，
        第三方方网站扛不住新增流量
        第三方服务挂掉

   四，DOS
     通过构造特定请求，导致服务器资源被显著消耗，来不及响应请求，导致请求挤压，进而雪崩效应
     正则表达式---贪婪模式
     [?] vs [no?] 满足一个即可vs多个
     贪婪：n次不行？n-1次再试试？--回溯？

   五，DDOS
     短时间内，大量僵尸设备请求流量，服务器不能及时完成全部请求，导致请求积累，进而雪崩效应，无法响应新请求。
     攻击特点
        -直接访问IP
        -任意API
        -消耗大量带宽

    六，中间人攻击             
       特点      （窃取信息，修改请求）
       Browser-------->中间人--------->Server
         1.明文传输
         2，信息篡改不可知
         3，对方身份未验证
    



2，防御篇

   一，XSS
      1，前端
           -主流框架默认防御XSS
           -goole-closure-library
      2,服务端(Node)
           -DOMPurify 
      3,Same-origin Policy
           -协议
           -域名
           -端口
           HTTP请求：同源，跨域
                  （1）http://example.com
                  （2）https://example.com
                  （3）https://sub.example.com
                  (1)(2)(3)都不是同源，（1）（2）协议不同，（2）（3）域名不同
    二，CSRF
       GET!=GET+POST
       避免用户信息被携带

    三， SameSite Cookie
                       一个cookie只能被自己页面所用
                       如果cookie依赖第三方服务怎么办？
                         比如内嵌一个b战播放器，识别不了用户登录状态，发不了弹幕
       Samesite                                   CORS
        -Cookie 发送                                -资源读写（HTTP请求）
        -domain vs 页面域名                         -资源域名 vs 页面域名
        -“我跟你说个事，出了这个屋我可就不认了”       -白名单

    四，Injecton beyeond SQL
       -最小权限原则
        -sudo || root
       -建立允许名单 + 过去
        -rm
       -对URL类型参数进行协议，域名，IP等限制
        -访问内网
           
    五，DDOS
       -流量治理    
         -负载均衡         过滤  
         -API网关
         -CDN

       -快速自动扩容       抗量
       -非核心服务降级     


    六，传输层--防御中间人
      HTTPS: HTTP
           : TLS

             TCP
             IP

      HTTPS的一些特性:
         -可靠性：加密           非明文
         -完整性：MAC验证        不可篡改
         -不可依赖性：数字签名    验证身份 