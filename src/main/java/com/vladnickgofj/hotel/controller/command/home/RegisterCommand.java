package com.vladnickgofj.hotel.controller.command.home;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageInvalidConfirmationPassword;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RegisterCommand implements Command {
    private final UserService userService;
    public static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws RegisterPageInvalidConfirmationPassword, ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirmationPassword");

        if (!Objects.equals(password, confirmationPassword) || Objects.equals(password, "")) {
            LOGGER.info("Password is not confirmed");
            request.getSession().setAttribute("firstName", firstName);
            request.getSession().setAttribute("lastName", lastName);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("confirmationPassword", "The password and confirm password fields do not match");
            throw new RegisterPageInvalidConfirmationPassword("The password and confirm password fields do not match");
        }
        UserDto userDto = new UserDto(1, firstName, lastName, email, password, confirmationPassword, Role.USER);
        LOGGER.info("userDto" + userDto);
        userService.register(userDto);
        userService.save(userDto);
        LOGGER.info("User saved");
        request.getSession().invalidate();
        request.setAttribute("userSaved", "User saved");
        return PagesConstant.REGISTRATION_PAGE;
    }

    private boolean emailValidation(HttpServletRequest req, String email) throws ServletException, IOException {
        String regExp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        if (!email.matches(regExp)) {
            req.setAttribute("message", "email is not correct");
            return true;
        }
        return false;
    }
}
