package com.zengzhaogui.week5;

import com.zengzhaogui.dao.UserDao;
import com.zengzhaogui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public static  Connection dbConn=null;
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
        dbConn=(Connection)getServletContext().getAttribute("dbConn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("username");
        String upwd=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(dbConn,uname,upwd);
            if(user!=null){
                request.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String password=null;
//        PrintWriter out=response.getWriter();
//        try{
//            Statement stmt=dbConn.createStatement();
//            ResultSet rs=stmt.executeQuery("select password from Usertable where username='"+uname+"'");
//            while(rs.next()){
//                password=rs.getString("password");
//            }
//            if(upwd.equals(password.trim())){
//                out.println("Login Success");
//                out.println("Welcome "+uname);
//            }else {
//                out.println("Password Error");
//            }
//
//        }catch (Exception e){
//            out.println("The users does not exist");
//        }

    }
}
