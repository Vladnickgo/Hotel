package com.vladnickgofj.hotel.controller;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.service.exception.AuthorisationFailException;
import com.vladnickgofj.hotel.service.exception.InvalidEmailException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ExceptionHandler extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handle(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, AuthorisationFailException, InvalidEmailException {
        handle(req, resp);
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Object attribute2 = req.getAttribute("javax.servlet.error.status_code");
            Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
            Object attribute1 = req.getAttribute("javax.servlet.error.exception");
            Object attribute = req.getAttribute("javax.servlet.error.exception_type");
            Object attribute3 = req.getAttribute("javax.servlet.error.message");
            String exceptionName = throwable.getClass().getSimpleName();

            Object statusCode = req.getAttribute("statusCode");
//            if (code.equals(404)) {
//                resp.sendRedirect(PagesConstant.PAGE_NOT_FOUND);
//            }
//            if (statusCode.equals(600)) {
////                            req.setAttribute("notRegisteredUser", "User is not registered");
//                req.setAttribute("authFailed", "true");
//                req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
//            }

//            if (exceptionName.equals("InvalidPasswordException")) {
//                req.setAttribute("authFailed", "true");
//                req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
////            resp.sendRedirect(PagesConstant.LOGIN_PAGE);
//            }

//            if (code.equals(500)) {
//                req.setAttribute("notCorrectEmail", "Email is not correct");
//                req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
//            }
            req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
//        resp.sendRedirect(PagesConstant.ERROR_MAIL_PAGE);

        } catch (IOException | ServletException e) {
            // TODO: 18.05.2022 Create redirect/forward on 500 page, add Logger

        }
    }
}
