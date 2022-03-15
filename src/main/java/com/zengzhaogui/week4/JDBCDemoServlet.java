package com.zengzhaogui.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdbtest;encrypt=false";
//        String username="ZZG";
//        String password="ZZG123456789";
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        String email=request.getParameter("email");
        String male=request.getParameter("male");
        String birthday=request.getParameter("birthday");
        //输入
        int id=1;
        try{
            Statement stmt=con.createStatement();
            String s="insert into Usertable(id,username,password,email,gender,birthday) values ( '"+id+","+username+"','"+
                    password+"','"+email+"','"+male+"','"+birthday+"');";
            int count=stmt.executeUpdate(s);
            if(count==1){
                System.out.println("successful");
                id++;
            }else{
                System.out.println("yinyinyin");
            }
        }catch(Exception e){
            System.out.println("出错了");
        }
       //输出
       try{
           Statement stmt= con.createStatement();
           ResultSet rs= stmt.executeQuery("select id,username,password,email,gender,birthday from userdbtest");
           while(rs.next()){
               PrintWriter out=response.getWriter();
               out.print(" "+rs.getString("id"));
               out.print(" "+rs.getString("username"));
               out.print(" "+rs.getString("password"));
               out.print(" "+rs.getString("email"));
               out.print(" "+rs.getString("gender"));
               out.print(" "+rs.getString("birthday"));

           }
       }catch (Exception e){
           System.out.println("出错了");
       }

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
