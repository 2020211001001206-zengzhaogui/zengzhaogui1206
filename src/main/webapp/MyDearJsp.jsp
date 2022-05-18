<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/5/18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Use java code</h1>
name:<%=request.getParameter("name")%><br>
submit:<%=request.getParameter("submitButton")%><br>
MyClass:<%=request.getParameter("myclass")%><br>
ID:<%=request.getParameter("id")%>
<hr>
<h1>Use EL</h1>
name:${param.name}<br>
submit:${param.submitButton}<br>
MyClass:${param.myclass}<br>
ID:${param.id}
<hr>
<h1>2020211001001206-zengzhaogui</h1>
