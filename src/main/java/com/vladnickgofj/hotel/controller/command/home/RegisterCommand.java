package com.vladnickgofj.hotel.controller.command.home;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;
import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.exception.EntityAlreadyExistException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
    private final UserService userService;
    public static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirmationPassword");
        UserDto userDto = UserDto.newBuilder()
                .id(1)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .confirmationPassword(confirmationPassword)
                .role(Role.USER)
                .build();
        LOGGER.info("userDto" + userDto);
        try {
            request.getSession();
            request.getSession().invalidate();
            userService.save(userDto);
            request.getSession().invalidate();
            request.getSession().setAttribute("userSaved", "true");
        } catch (IllegalArgumentException | EntityAlreadyExistException exception) {
            String message = exception.getMessage();
            LOGGER.info(message);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("message", message);
        }
        return PagesConstant.REGISTRATION_PAGE;
    }
}
