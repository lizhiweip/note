<%--jsp表达式
作用：用来将程序的输出，输出到客户端
--%>
<%=变量或表达式%>
<%= new java.util.Date()%>

<%--jsp脚本片段--%>
<%
   int sum=0;
  for(int i=1;i<100;i++){
  sum+=i;
  }
  out.println("<h1>sum="+sum+"</h1>");
 %>

<%--在代码中嵌入HTML元素--%>
<%
  for(int i=0;i<5;i++){
  %>
    <h1>Hello,World<h1>
  <%
  }
  %>

<!--我是html的注释-->
<%--我是jsp的注释--%>
<%--内置对象--%>

<%
pageContext.setAttribute("name1","荔枝味1")；//保存的数据只在一个页面中有效
request.setAttribute("name2","荔枝味2")；//保存的数据只在一次请求中有效
session.setAttribute("name3","荔枝味3")；//保存的数据只在一次会话中有效
application.setAttribute("name4","荔枝味4")；//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%--脚本中的代码回原封不动的生成到JSP.java,所以这里的代码要保证正确性--%>
<%
  //从pageContext中取，用寻找的方法
  //从底层到高层（作用域）
  String name1=(String) pageContext.findAttribute("name1");
%>
<%--使用EL表达式输出 ${}--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>