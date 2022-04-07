package com.vladnickgofj.hotel.controller.command.user;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        // TODO: 4/7/2022  some logic
        return PagesConstant.HOME_PAGE;
    }
}
