package com.vladnickgofj.hotel.controller.command.user;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.servlet.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class RegisterCommand implements Command {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        // TODO: 04.04.2022 logic for registration
        //to move logic form doSighIn in HelloServlet
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = (String) request.getSession().getAttribute("password");
        String confirmationPassword = (String) request.getSession().getAttribute("confirmationPassword");

        if (!Objects.equals(password, confirmationPassword) || Objects.equals(password, "")) {
            request.setAttribute("confirmationPassword", "Password not Equal");
            return PagesConstant.REGISTRATION_PAGE;
        }
        UserDto userDto = new UserDto(1, firstName, lastName, email, password, confirmationPassword, Role.USER);
        try {
            userService.save(userDto);
        }catch (Exception e){

        }
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
