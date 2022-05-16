package com.vladnickgofj.hotel.controller;

import com.vladnickgofj.hotel.PagesConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer code = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        String exceptionType = (String) req.getAttribute("javax.servlet.error.exception_type");
        String attribute2 = (String)req.getAttribute("javax.servlet.error.request_uri");
        String servletName =(String) req.getAttribute("javax.servlet.error.servlet_name");
        String exception = (String)req.getAttribute("javax.servlet.error.exception");
        System.out.println("-----------------------------");
        System.out.println("code: :"+code);
        System.out.println("message: "+message);
        System.out.println("exceptionType: "+exceptionType);
        System.out.println("servletName: "+servletName);
        System.out.println("exception: "+exception);
        System.out.println("-----------------------------");

        resp.sendRedirect(PagesConstant.PAGE_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        System.out.println("email "+email);
//        String code = (String)req.getParameter("javax.servlet.error.status_code");
//        System.out.println("code: "+code);
        System.out.println(")))))))))))))");
        resp.sendRedirect(PagesConstant.ERROR_MAIL_PAGE);
    }
}
