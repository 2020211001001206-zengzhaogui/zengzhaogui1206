<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/3/13
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is my register JSPpage.<br>
<form name="form" id="form" method="post" action="jdbc">
<div class="word">New User Registration!</div>
<input type="text" placeholder="User" name="username" class="messagedata"><br/>
<input type="password" placeholder="password" name="password" class="messagedata"><br/>
<input type="email" placeholder="Email" name="email" class="messagedata"><br/>

<div class="word">Gender<input type="radio" name="male" value="male " checked>Male
    <input type="radio" name="male" value="female">Female</div>
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
    // document.getElementById("bt").onclick=function click(){
    //     var a=form.username.value.trim();
    //     var b=form.password.value.trim();
    //     var c=form.email.value.trim();
    //     var d=form.birthday.value.trim();
    //     if(b.length<8){
    //         alert("密码的长度必须在8位以上!!!")
    //     }else if(d.length!=10){
    //         alert("请输入生日的正确格式!!!")
    //     }
    //     if(a!=""&&b.length>=8&&c!=""&&d.length==10){
    //         alert("注册成功!!!")
    //     }else{
    //         alert("请输入完整信息!!!")
    //     }
    //
    // }
</script>
<%@include file="footer.jsp"%>
