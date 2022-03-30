<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/30
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
username:<%=request.getParameter("username")%><br>
password:<%=request.getParameter("password")%><br>
email:<%=request.getParameter("email")%><br>
male:<%=request.getParameter("male")%><br>
birthday:<%=request.getParameter("birthday")%><br>

</body>
</html>
