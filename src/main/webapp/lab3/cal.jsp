<%--
  Created by IntelliJ IDEA.
  User: ZZG
  Date: 2022/5/29
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String first="",second="",result="",name="",length="";
    Cookie cookies[]= request.getCookies();
    for(int i=0;i<cookies.length;i++){
        if(cookies[i].getName().equals("first")){
            first=cookies[i].getValue();
        }
        if(cookies[i].getName().equals("second")){
            second=cookies[i].getValue();
        }
        if(cookies[i].getName().equals("result")){
            result=cookies[i].getValue();
        }
    }

    for (int i=0;i<cookies.length;i++) {
        if (cookies[i].getName().equals("name")) {
            name = cookies[i].getValue();
        }
        if (cookies[i].getName().equals("length")) {
            length = cookies[i].getValue();
        }
    }


%>
<form action="<%=request.getContextPath()%>/cal" method="post" name="form">
    First val:<input name="first" type="text" value="<%=first%>">&nbsp;&nbsp;&nbsp;Enter a name:<input name="name" type="text" value="<%=name%>"><br>
    Second val:<input name="second" type="text" value="<%=second%>">&nbsp;&nbsp;&nbsp;Length:<input name="length" type="text" value="<%=length%>"><br>
    Result:<input name="result" type="text" value="<%=result%>"><br>
    <input type="submit" name="cal" value="Add" onclick="login()">
    <input type="submit" name="cal" value="Subtract" onclick="login()">
    <input type="submit" name="cal" value="Multiply" onclick="login()">
    <input type="submit" name="cal" value="Divide" onclick="login()">
    <input type="submit" name="cal" value="ComputeLength" onclick="getLength()">
    <input type="reset" value="Reset">
</form>
<script>
   function login(){
       let firstNumber=form.first.value;
       let secondNumber=form.second.value;
       try{
           if(firstNumber%1!=0){
               alert("The first Value is not a Number");
           }
           if(secondNumber%1!=0){
               alert("The second Value is not a Number");
           }
       }catch (Exception){
           alert("There is some problems");
       }

   }

   function getLength() {
       let length=form.name.value;
       if(length==""){
           alert("Name Value is not a Number");
       }
   }

</script>
