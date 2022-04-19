<%@ page import="com.zengzhaogui.model.User" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/4/17
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
Update your informations<br>
<%
    User user=(User) session.getAttribute("user");
%>
<form name="form" id="form" method="post" action="update">
    <div class="word">New User Registration!</div>
    <input type="text" placeholder="User" name="username" class="messagedata" value="<%=user.getUsername()%>"><br/>
    <input type="password" placeholder="password" name="password" class="messagedata"value="<%=user.getPassword()%>"><br/>
    <input type="email" placeholder="Email" name="email" class="messagedata" value="<%=user.getEmail()%>"><br/>

    <div class="word">Gender<input type="radio" name="male" value="male "<%=user.getGender().trim().equals("male")?"checked":""%>>Male
        <input type="radio" name="male" value="female" <%=user.getGender().trim().equals("female")?"checked":""%>>Female</div>
    <input type="text" placeholder="Date of borth(yyyy-mm-dd)" name="birthday" class="messagedata"><br/>
    <input type="submit" value="Register" id="bt">
</form>
<script>
    document.getElementById("form").style.marginLeft="50px";
    //按钮
    document.getElementById("bt").style.backgroundColor="orange";
    document.getElementById("bt").style.marginTop="10px";
    document.getElementById("bt").style.color="white";
    document.getElementById("bt").style.width="100px";
    document.getElementById("bt").style.height="26px";

    //输入框
    var messagedata=document.getElementsByClassName("messagedata");
    for(var i=0;i<messagedata.length;i++){
        document.getElementsByClassName("messagedata")[i].style.width="280px";
        document.getElementsByClassName("messagedata")[i].style.height="30px";
        document.getElementsByClassName("messagedata")[i].style.backgroundColor="rgb(239,238,233)";
        document.getElementsByClassName("messagedata")[i].style.marginTop="10px";
        document.getElementsByClassName("messagedata")[i].style.borderStyle="none";
    }
    var word=document.getElementsByClassName("word");
    for(var i=0;i<word.length;i++){
        document.getElementsByClassName("word")[i].style.color="gray";
        document.getElementsByClassName("word")[i].style.marginTop="10px";
    }
</script>
