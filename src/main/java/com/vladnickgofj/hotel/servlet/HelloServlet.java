package com.vladnickgofj.hotel.servlet;

import com.vladnickgofj.hotel.dao.UserDao;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.dao.impl.UserDaoImpl;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.impl.UserServiceImpl;
import com.vladnickgofj.hotel.servlet.dto.UserDto;
import org.apache.tomcat.jni.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regExp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmationPassword = req.getParameter("confirmationPassword");
        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("email", email);
        String param = req.getParameter("option");
        req.setAttribute("message", param);
        if (!email.matches(regExp)) {
            req.setAttribute("message", "email is not correct");
            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
            return;
        }

        if (!Objects.equals(password, confirmationPassword) || Objects.equals(password, "")) {
            // TODO: 03.03.2022 DO something
            // TODO: 03.03.2022 send msg "Password not Equal"
            req.setAttribute("confirmationPassword", "Password not Equal");
            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
            return;
        }
        UserDto userDto = new UserDto(1, firstName, lastName, email, password, confirmationPassword, Role.USER);
        userService.save(userDto);
        getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
    }

    //todo example
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String email = req.getParameter("email");
        String param = req.getParameter("option");
        req.setAttribute("email", email);
        req.setAttribute("message", param);
        getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
        userService.save(new UserDto(1,"1","1","asd@asd.asd","1","1",Role.USER));

    }
}