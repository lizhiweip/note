<%--
  Created by IntelliJ IDEA.
  User: 李志炜
  Date: 2022/7/26
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <%--js是一个很随便的语言--%>
    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$(#username).val()},
        success:function(data){
            alert(data);
        }
              })
      }
    </script>
  </head>
  <body>

  <%--失去焦点的时候，发起一个请求(携带信息 )到后台--%>

  用户名：<input type="text" id="username" onblur="a()">


  </body>
</html>
