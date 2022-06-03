package com.zengzhaogui.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalServlet", value = "/cal")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/Lab3/cal.jsp").forward(request,response);
    }

    public  double Add(double a,double b){
        return (a+b);
    }

    public double Subtract(double a,double b){
        return (a-b);
    }

    public double Multiply(double a,double b){
        return (a*b);
    }

    public double Divide(double a,double b){
        return (a/b);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getParameter("cal").equals("Add")) {
                try {
                    double a=Double.parseDouble(request.getParameter("first"));
                    double b=Double.parseDouble(request.getParameter("second"));
                    double result = Add(a, b);

                    Cookie firstCookie=new Cookie("first",request.getParameter("first"));
                    Cookie secondCookie=new Cookie("second",request.getParameter("second"));
                    Cookie resultCookie=new Cookie("result",String.valueOf(result));

                    firstCookie.setMaxAge(60);
                    secondCookie.setMaxAge(60);
                    resultCookie.setMaxAge(60);

                    response.addCookie(firstCookie);
                    response.addCookie(secondCookie);
                    response.addCookie(resultCookie);
                } catch (Exception e) {

                }
            } else if (request.getParameter("cal").equals("Subtract")) {
                try {
                    double a=Double.parseDouble(request.getParameter("first"));
                    double b=Double.parseDouble(request.getParameter("second"));
                    double result = Subtract(a, b);

                    Cookie firstCookie=new Cookie("first",request.getParameter("first"));
                    Cookie secondCookie=new Cookie("second",request.getParameter("second"));
                    Cookie resultCookie=new Cookie("result",String.valueOf(result));

                    firstCookie.setMaxAge(60);
                    secondCookie.setMaxAge(60);
                    resultCookie.setMaxAge(60);

                    response.addCookie(firstCookie);
                    response.addCookie(secondCookie);
                    response.addCookie(resultCookie);
                } catch (Exception e) {

                }

            } else if (request.getParameter("cal").equals("Multiply")) {
                try {
                    double a=Double.parseDouble(request.getParameter("first"));
                    double b=Double.parseDouble(request.getParameter("second"));
                    double result = Multiply(a, b);

                    Cookie firstCookie=new Cookie("first",request.getParameter("first"));
                    Cookie secondCookie=new Cookie("second",request.getParameter("second"));
                    Cookie resultCookie=new Cookie("result",String.valueOf(result));

                    firstCookie.setMaxAge(60);
                    secondCookie.setMaxAge(60);
                    resultCookie.setMaxAge(60);

                    response.addCookie(firstCookie);
                    response.addCookie(secondCookie);
                    response.addCookie(resultCookie);
                } catch (Exception e) {

                }

            } else if (request.getParameter("cal").equals("Divide")) {
                try {
                    double a=Double.parseDouble(request.getParameter("first"));
                    double b=Double.parseDouble(request.getParameter("second"));
                    double result = Divide(a, b);

                    Cookie firstCookie=new Cookie("first",request.getParameter("first"));
                    Cookie secondCookie=new Cookie("second",request.getParameter("second"));
                    Cookie resultCookie=new Cookie("result",String.valueOf(result));

                    firstCookie.setMaxAge(60);
                    secondCookie.setMaxAge(60);
                    resultCookie.setMaxAge(60);

                    response.addCookie(firstCookie);
                    response.addCookie(secondCookie);
                    response.addCookie(resultCookie);
                } catch (Exception e) {

                }

            }else if(request.getParameter("cal").equals("ComputeLength")){
                try{
                    Cookie nameCookie=new Cookie("name",request.getParameter("name"));
                    Cookie lengthCookie=new Cookie("length",String.valueOf(request.getParameter("name").length()));
                    nameCookie.setMaxAge(60);
                    lengthCookie.setMaxAge(60);
                    response.addCookie(nameCookie);
                    response.addCookie(lengthCookie);
                }catch (Exception e){

                }
            }

        response.sendRedirect("Lab3/cal.jsp");
    }
}
