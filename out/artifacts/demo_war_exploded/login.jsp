<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/28
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="login">
  <h1>Login</h1>
  username:<input type="text" name="username" placeholder="username"><br>
  password:<input type="password" name="password" placeholder="password"><br>
  <input type="submit" value="Login"><br>
</form>
<%@include file="footer.jsp"%>
