package com.zengzhaogui.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection dbConn=null;

    @Override
    public void init() throws ServletException {
        super.init();
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdbtest;encrypt=false";
        //这里是写你的数据库名字。上面是新建立了Test，所以填Test
        String username="ZZG";//这里是写你的登陆数据库的名，安装完默认是sa
        String password="ZZG123456789";//这里是写你的登陆数据库的密码，我设定的比较简单
        try{
            System.out.println("1206");
            Class.forName(driverName);
            System.out.println("驱动成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("驱动失败");
        }
        try{
            dbConn= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接失败");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//
//        String email=request.getParameter("email");
//        String male=request.getParameter("male");
//        String birthday=request.getParameter("birthday");
//        int id=1;
//        try{
//            Statement stmt= dbConn.createStatement();
//            String sqll="insert into Usertable(id,username,password,email,gender,birthday) values ( '"+id+","+username+"','"+
//                    password+"','"+email+"','"+male+"','"+birthday+"');";
//            int count=stmt.executeUpdate(sqll );
//            if(count>0){
//                System.out.println("successful");
//                id++;
//            }else{
//                System.out.println("yinyinyin");
//            }
//        }catch(Exception e){
//            System.out.println("出错了");
//
//        }
//
//
//        PrintWriter writer=response.getWriter();
//        writer.println("<br>username"+username);
//        writer.println("<br>password"+password);
//        writer.println("<br>email"+email);
//        writer.println("<br>male"+male);
//        writer.println("<br>birthday"+birthday);
//        writer.close();


    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            dbConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
