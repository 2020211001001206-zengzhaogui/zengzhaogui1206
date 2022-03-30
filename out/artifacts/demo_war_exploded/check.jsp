<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/28
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% Connection con;
    Statement sql;
    ResultSet rs;
    try {  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
        out.println("加载驱动成功！");
        try{ String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdbtest";//地址+端口号，数据库名字
            String user="ZZG";//登录名
            String password="ZZG123456789";//登陆密码
            con=DriverManager.getConnection(url,user,password);
            out.println("连接数据库成功！");
        }
        catch(SQLException e){
            out.print("SQL Server连接失败！");}
    }
    catch(Exception e){
        out.println("加载驱动失败！");}
%>

</body>
</html>
