package com.vladnickgofj.hotel.controller;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.filter.LocalFilter;
import com.vladnickgofj.hotel.service.exception.AuthorisationFailException;
import com.vladnickgofj.hotel.service.exception.InvalidEmailException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ExceptionHandler extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class);

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

    private void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            int status = resp.getStatus();
            Object command = req.getAttribute("command");
            Integer code = (Integer) req.getAttribute("javax.servlet.error.status_code");

            if (code.equals(404)) {
                LOGGER.info("HTTP Status " + code);
                resp.sendRedirect(PagesConstant.PAGE_NOT_FOUND);
            }

            Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
            String exceptionName = throwable.getClass().getSimpleName();
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            LOGGER.info("firstName " + firstName);
            LOGGER.info(lastName);
            LOGGER.info(email);
            LOGGER.info("exceptionName: " + exceptionName);

            if ("InvalidPasswordException".equals(exceptionName)) {
                req.setAttribute("authFailed", "true");
                LOGGER.info(exceptionName + "forward to LOGIN_PAGE");
//                resp.sendRedirect(PagesConstant.LOGIN_PAGE);
                req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
            }

            if ("InvalidEmailException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("loginPageEmail", email);
                req.getSession().setAttribute("authFailed", "true");
                resp.sendRedirect(PagesConstant.LOGIN_PAGE);
            }

            if ("IllegalArgumentException".equals(exceptionName)) {
                req.getRequestDispatcher(PagesConstant.PAGE_NOT_FOUND).forward(req, resp);
            }

            if ("RegisterPageInvalidConfirmationPassword".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidConfirmPassword", "true");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }

            if ("AuthorisationFailException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("loginPageEmail", email);
                req.getSession().setAttribute("authFailed", "true");
                resp.sendRedirect(PagesConstant.LOGIN_PAGE);
            }

            if ("RegisterPageEmailErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidEmail", "true");
                LOGGER.info("Not valid Email");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("RegisterPageFirstNameErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidFirstName", "true");
                LOGGER.info("Not valid Name");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("RegisterPageLastNameErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidLastName", "true");
                LOGGER.info("Not valid lastName");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("RegisterPagePasswordErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidPassword", "true");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("RegisterPageConfirmationPasswordErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("notValidConfirmPassword", "true");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("RegisterPageEntityAlreadyExistException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("firstName", firstName);
                req.getSession().setAttribute("lastName", lastName);
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("userAlreadyExist", "true");
                resp.sendRedirect(PagesConstant.REGISTRATION_PAGE);
            }
            if ("LoginPageEmailErrorException".equals(exceptionName)) {
                req.getSession().invalidate();
                req.getSession().setAttribute("loginPageEmail", email);
                req.getSession().setAttribute("authFailed", "true");
                resp.sendRedirect(PagesConstant.LOGIN_PAGE);
            }

            if (code.equals(500)) {
                req.setAttribute("codeOfError", code);
                LOGGER.info("HTTP Status " + code);
                req.getRequestDispatcher(PagesConstant.INTERNAL_SERVER_ERROR_PAGE).forward(req, resp);
            }
            req.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(req, resp);
        } catch (IOException | ServletException e) {
            LOGGER.info("Internal Server Error" + e);
            resp.sendRedirect(PagesConstant.INTERNAL_SERVER_ERROR_PAGE);
        }
    }
}
