package com.zengzhaogui.controller;

import com.zengzhaogui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = {"/admin/home","/admin/login"})
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            User user=(User) session.getAttribute("user");
            if(user.getUsername().equals("admin")){
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }else {
               session.invalidate();
               request.setAttribute("message","oh No");
               request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("message","Please login");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
