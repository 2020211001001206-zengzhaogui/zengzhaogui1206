package com.zengzhaogui.controller;

import com.zengzhaogui.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

@WebServlet(name = "GetImgServlet", value = "/getImg")
public class GetImgServlet extends HttpServlet {
    Connection dbConn=null;

    @Override
    public void init() throws ServletException {
        super.init();
        dbConn=(Connection) getServletContext().getAttribute("dbConn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao productDao=new ProductDao();
        int id=0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }
        byte[] imgByte=new byte[0];
        try {
            imgByte=productDao.getPictureById(id,dbConn);
            if(imgByte!=null){
                response.setContentType("image/gif");
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(imgByte);
                outputStream.flush();
            }
        }catch (Exception e){
            System.out.println("oh No");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
