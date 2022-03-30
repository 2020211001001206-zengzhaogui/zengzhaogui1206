<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.zengzhaogui.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/30
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user=(User) request.getAttribute("user");
%>
<table border="1">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>gender</td>
        <td>birthdate</td>
    </tr>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getGender()%></td>
            <td><%=user.getBirthdate()%></td>
        </tr>
</table>
</body>
</html>
