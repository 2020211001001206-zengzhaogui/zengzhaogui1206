package com.zengzhaogui.week6;

import javax.print.attribute.Size2DSyntax;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String choose=request.getParameter("search");
        if(choose.equals("qq")){
            response.sendRedirect("https://www.qq.com/");
        }else if(choose.equals("baidu")){
            response.sendRedirect("https://www.baidu.com/");
        }else if(choose.equals("taobao")){
            response.sendRedirect("https://www.taobao.com/");
        } else{
            PrintWriter out=response.getWriter();
            out.println("oh no");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
