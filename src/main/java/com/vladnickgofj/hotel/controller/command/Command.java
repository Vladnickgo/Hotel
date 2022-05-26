package com.vladnickgofj.hotel.controller.command;

import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageInvalidConfirmationPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RegisterPageInvalidConfirmationPassword;
}
