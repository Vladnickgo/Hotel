package com.vladnickgofj.hotel.controller.filter;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.dao.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*UserSecurityFilter
 * для проверки пользователя необходимо проверить сессию на наличие пользователя
 * и его роль. Если пользователь не создан
 *
 *
 *
 *
 *
 *
 *
 */
@WebFilter(urlPatterns = "/user/*",
        dispatcherTypes = {
                DispatcherType.REQUEST,
                DispatcherType.FORWARD
        })
//@WebFilter("/*")
public class UserSecurityFilter implements Filter {
    private static Logger LOGGER = Logger.getLogger(UserSecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Log from UserSecurityFilter, method init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Log from UserSecurityFilter, method doFilter()");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");

        if (user == null || !Role.USER.equals(user.getRole())) {
            request.getRequestDispatcher(PagesConstant.LOGIN_PAGE).forward(request, servletResponse);
        } else {
            filterChain.doFilter(request, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
