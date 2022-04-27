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
    Connection dbConn=null;
    @Override
    public void init() throws ServletException {
        super.init();
//        String driver=getServletConfig().getServletContext().getInitParameter("driver");
//        String url=getServletConfig().getServletContext().getInitParameter("url");
//        String username=getServletConfig().getServletContext().getInitParameter("username");
//        String password=getServletConfig().getServletContext().getInitParameter("password");
//        try{
//            Class.forName(driver);
//            System.out.println("加载驱动成功！");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            System.out.println("加载驱动失败！");
//        }
//        try{
//            dbConn=DriverManager.getConnection(url,username,password);
//            System.out.println("连接数据库成功！");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            System.out.print("SQL Server连接失败！");
//        }
        dbConn=(Connection) getServletContext().getAttribute("dbConn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        String email=request.getParameter("email");
        String male=request.getParameter("gender");
        String birthday=request.getParameter("birthDate");
        //输入
        int id=1;
        try{
            Statement stmt=dbConn.createStatement();
            ResultSet rs= stmt.executeQuery("select * from Usertable");
            while(rs.next()){
                id++;
            }
        }catch(Exception e){
            System.out.println("geigei");
        }
        try{
            Statement stmt=dbConn.createStatement();
            String s="insert into Usertable(id,username,password,email,gender,birthdate) values ( "+id+",'"+username+"','"+
                    password+"','"+email+"','"+male+"','"+birthday+"');";
            int count=stmt.executeUpdate(s);
            if(count==1){
                System.out.println("successful");
            }else{
                System.out.println("yinyinyin");
            }
        }catch(Exception e){
            System.out.println("出错了");
        }
       //输出
       try{
           Statement stmt= dbConn.createStatement();
           ResultSet rs= stmt.executeQuery("select id,username,password,email,gender,birthdate from Usertable");
           request.setAttribute("rsname",rs);
//           while(rs.next()){
//               PrintWriter out=response.getWriter();
//               out.print(" "+rs.getString("id"));
//               out.print(" "+rs.getString("username"));
//               out.print(" "+rs.getString("password"));
//               out.print(" "+rs.getString("email"));
//               out.print(" "+rs.getString("gender"));
//               out.print(" "+rs.getString("birthdate"));
//               out.println();
//           }
           request.getRequestDispatcher("userInfo.jsp").forward(request,response);
       }catch (Exception e){
           System.out.println("出错了");
       }

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
