package com.zengzhaogui.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ServletContextListener.super.contextInitialized(sce);
        ServletContext context= sce.getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try{
            Class.forName(driver);
            System.out.println("加载驱动成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try{
            Connection dbConn= DriverManager.getConnection(url,username,password);
            System.out.println("连接数据库成功！");
            context.setAttribute("dbConn",dbConn);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //ServletContextListener.super.contextDestroyed(sce);
        sce.getServletContext().removeAttribute("dbConn");
    }
}
