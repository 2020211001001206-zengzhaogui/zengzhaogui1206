package com.zengzhaogui.controller;

import com.zengzhaogui.dao.UserDao;
import com.zengzhaogui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SIUDServlet", value = "/siud")
public class SIUDServlet extends HttpServlet {
    Connection dbConn=null;
    @Override
    public void init() throws ServletException {
        super.init();
        dbConn=(Connection) getServletContext().getAttribute("dbConn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/siud.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation=request.getParameter("operation");
        PrintWriter out=response.getWriter();

        if(operation.equals("findByUsername")){
            out.println("findByUsername");
        }else if (operation.equals("findByPassword")){
            out.println("findByPassword");
        }else  if(operation.equals("findByBirthdate")){
            out.println("findByBirthdate");
        }else if(operation.equals("findByGender")){
            String gender=request.getParameter("male");
            List<User> u=new ArrayList<>();
            UserDao userDao=new UserDao();
            try{
                u=userDao.findByGender(dbConn,gender);
                if(u!=null){
                    for(int i=0;i<u.size();i++){
                        User s=u.get(i);
                        out.print(s.getId()+" ");
                        out.print(s.getUsername()+" ");
                        out.print(s.getPassword()+" ");


                    }
                }

            }catch (Exception e){
                out.println("Error");
            }
        }else  if(operation.equals("findById")){
            out.println("findById");
        }


    }
}
