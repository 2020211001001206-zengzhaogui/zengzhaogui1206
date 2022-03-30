<%@ page import="com.zengzhaogui.model.User" %>
<%@include file="header.jsp"%>
<%
    User user1=(User) session.getAttribute("user");
%>
username:<%=user1.getUsername()%><br>
password:<%=user1.getPassword()%><br>
email:<%=user1.getEmail()%><br>
male:<%=user1.getGender()%><br>
birthday:<%=user1.getBirthdate()%><br>
<a href="update">update</a>
<%@include file="footer.jsp"%>
