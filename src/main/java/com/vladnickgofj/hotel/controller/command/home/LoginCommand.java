package com.vladnickgofj.hotel.controller.command.home;

import com.vladnickgofj.hotel.HttpStatusCodes;
import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;
import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.dao.exception.loginPageExceptions.LoginPageEmailErrorException;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.exception.InvalidPasswordException;
import com.vladnickgofj.hotel.service.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        UserDto byEmail = userService.findByEmail(email);
        if (emailValidation(email)) {
            throw new LoginPageEmailErrorException("Email not correct");
        }
        if (email.equals(byEmail.getEmail()) && pass.equals(byEmail.getPassword())) {
            User user = new UserMapper().mapDtoToEntity(byEmail);
            user.setPassword(StringUtils.EMPTY);
            session.setAttribute("user", user);
        } else {
            request.setAttribute("statusCode",HttpStatusCodes.NOT_CORRECT_PASSWORD);
            throw new InvalidPasswordException("Password is not correct");
        }
        return PagesConstant.HOME_PAGE;
    }

    private boolean emailValidation(String email) {
        String regExp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        return !email.matches(regExp);
    }
}
