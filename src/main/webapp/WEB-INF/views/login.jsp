<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/28
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="login">
  <%
  Cookie[] allCookies=request.getCookies();
  String username="",password="",rememberMeVal="";
  if(allCookies!=null){
    for(int i=0;i<allCookies.length;i++){
      if(allCookies[i].getName().equals("uname")){
        username=allCookies[i].getValue();
      }
      if(allCookies[i].getName().equals("upwd")){
        password=allCookies[i].getValue();
      }
      if(allCookies[i].getName().equals("urememberMeVal")){
        rememberMeVal=allCookies[i].getValue();
      }

    }

  }

  %>
  <h1>Login</h1>
  username:<input type="text" name="username" placeholder="username" value="<%=username%>"><br>
  password:<input type="password" name="password" placeholder="password" value="<%=password%>"><br>
  <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>>RememberMe<br>
<%--  <input type="checkbox" name="rememberMe" value="<%=rememberMeVal%>">RememberMe<br>--%>
  <input type="submit" value="Login"><br>
</form>
<%@include file="footer.jsp"%>
