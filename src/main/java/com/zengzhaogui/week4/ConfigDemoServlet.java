package com.zengzhaogui.week4;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="ConfigDemoServlet",value="/config",
        initParams = {
        @WebInitParam(name="Name",value="zengzhaogui"),
                @WebInitParam(name="Id",value="2020211001001206"),
        }

)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String Name=config.getInitParameter("Name");
        String Id=config.getInitParameter("Id");
        PrintWriter out=response.getWriter();
        out.println("Name:"+Name);
        out.println("Id:"+Id);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
