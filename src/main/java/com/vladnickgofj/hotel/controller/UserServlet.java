package com.vladnickgofj.hotel.controller;

import javax.servlet.annotation.WebServlet;

//@WebServlet("/user")
public class UserServlet extends AbstractServlet{
    UserServlet() {
        super("user", "home");
    }
}
