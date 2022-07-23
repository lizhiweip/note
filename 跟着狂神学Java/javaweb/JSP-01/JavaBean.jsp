<%@ page contentType="text/html";charset="utf-8" language="java">
<html>
  <head>
    <title>Title</title>
  </head>
  <body>


  <%
  //People people=new People();
  //people.setAddress("宜春")；
  //people.setID(1);
  %>


    <jsp:useBean id="people" class="com.li.People" scope="page">

    <jsp:setProperty name="people" property="address" value="宜春"/>
    <jsp:setProperty name="people" property="id" value="1"/>
    <jsp:setProperty name="people" property="age" value="3"/>
    <jsp:setProperty name="people" property="name" value="荔枝味"/>


  </body>
</html>