package com.vladnickgofj.hotel.controller.command.user;

import com.vladnickgofj.hotel.PagesConstant;
import com.vladnickgofj.hotel.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ShowProfileCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return PagesConstant.USER_PROFILE;
    }
}