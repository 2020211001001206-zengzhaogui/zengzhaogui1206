<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/5/1
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bean" class="com.zengzhaogui.week10.StringBean"/>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>
<jsp:getProperty name="bean" property="message"/>



