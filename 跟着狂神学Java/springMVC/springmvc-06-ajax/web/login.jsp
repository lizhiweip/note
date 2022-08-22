<%--
  Created by IntelliJ IDEA.
  User: 李志炜
  Date: 2022/7/27
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        function a1(){
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data:{"name":$("#name").val()},
                success:function(data){
                   if(data.toString()=="ok"){
                       $("#userInfo").css("color","green");
                   }
                   $("#userInfo").html(data);
             }
            });
        }
        function a2(){
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data:{"pwd":$("#pwd").val()},
                success:function(data){
                    console.log(data);
                }
            });
        }
    </script>
</head>
<body>

<p>
    用户名：<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码：<input type="text" id="pwd" onblur="a2()">
    <span id="pwdInfo"></span>
</p>

</body>
</html>
