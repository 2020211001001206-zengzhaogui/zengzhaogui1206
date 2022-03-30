<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %><%--
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
<table border="1">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>gender</td>
        <td>birthdate</td>
    </tr>
    <%
        ResultSet rs=(ResultSet)request.getAttribute("rsname");
        while(rs.next()){  %>
        <tr>
            <td><%=rs.getString("id")%></td>
            <td><%=rs.getString("username")%></td>
            <td><%=rs.getString("password")%></td>
            <td><%=rs.getString("email")%></td>
            <td><%=rs.getString("gender")%></td>
            <td><%=rs.getString("birthdate")%></td>
        </tr>
      <%}%>

</table>
</body>
</html>
