<%@include file="header.jsp"%>
<h1>Welcome to my home page .</h1>
<!-- <a href="hello">Student Info Servlet-week2</a> <br>
<a href="register.jsp">Register-getParameter-week3</a> <br>
<a href="config">Config parameter-week4</a> <br>
<a href="register.jsp">Register JDBC-week4</a> <br>
<a href="index.jsp">include-week5</a> <br>
<a href="login.jsp">login-week5</a> <br> -->
  <form method="get"  action="search">
    <select name="text">
      <option value="baidu">baidu</option>
      <option value="qq">QQ</option>
      <option value="taobao">taobao</option>
    </select>
    <input type="submit" value="Search">
  </form>
<%@include file="footer.jsp"%>
