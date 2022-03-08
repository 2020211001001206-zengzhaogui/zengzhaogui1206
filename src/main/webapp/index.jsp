<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form name="form" id="form">
    <div class="word">New User Registration!</div>
    <input type="text" placeholder="Username" name="username" class="messagedata"><br/>
    <input type="password" placeholder="passward"v name="password" class="messagedata"><br/>
    <input type="email" placeholder="Email" name="email" class="messagedata"><br/>

    <div class="word">Gender<input type="radio" name="male" checked>Male<input type="radio" name="male">Female</div>
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
    //事件监听
    document.getElementById("bt").onclick=function click(){
        var a=form.username.value.trim();
        var b=form.password.value.trim();
        var c=form.email.value.trim();
        var d=form.birthday.value.trim();
        if(b.length<8){
            alert("密码的长度必须在8位以上!!!")
        }else if(d.length!=10){
            alert("请输入生日的正确格式!!!")
        }
        if(a!=0&&b.length>=8&&c!=0&&d.length==10){
            alert("注册成功!!!")
        }else{
            alert("请输入完整信息!!!")
        }

    }
</script>
<h3>Name:zengzhaogui</h3>
<h3>ID:2020211001001206</h3>
<h3>Date and Time:Sun March 6 16:27:07 CST 2022</h3>
</body>
</html>