package com.zengzhaogui.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection dbConn=null;
    @Override
    public void init() throws ServletException {
        super.init();
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try{
            Class.forName(driver);
            System.out.println("加载驱动成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try{
            dbConn=DriverManager.getConnection(url,username,password);
            System.out.println("连接数据库成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("username");
        String upwd=request.getParameter("password");
        String password=null;
        PrintWriter out=response.getWriter();
        try{
            Statement stmt=dbConn.createStatement();
            ResultSet rs=stmt.executeQuery("select password from Usertable where username='"+uname+"'");
            while(rs.next()){
                password=rs.getString("password");
            }
            if(upwd.equals(password.trim())){
                out.println("Login Success");
                out.println("Welcome "+uname);
            }

        }catch (Exception e){
            out.println("oh no");
        }

    }
}
