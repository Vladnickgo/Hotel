package com.vladnickgofj.hotel.controller.filter;


import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.service.exception.AuthorisationFailException;
import org.apache.log4j.Logger;

import javax.security.sasl.AuthenticationException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/home/*")
public class HomeSecurityFilter implements Filter {
    public static final Logger logger = Logger.getLogger(HomeSecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Init HomeSecurityFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthorisationFailException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        logger.info("doFiler");
        User user = (User) req.getSession().getAttribute("user");
        String command = req.getParameter("command");
        if ((user == null || !Role.USER.equals(user.getRole())) && "show-profile".equals(command)) {
            throw new AuthorisationFailException("The page is not available");
        }
        chain.doFilter(req, response);


    }

    @Override
    public void destroy() {

    }
}
