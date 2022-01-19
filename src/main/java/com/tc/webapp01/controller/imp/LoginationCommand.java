package com.tc.webapp01.controller.imp;

import com.tc.webapp01.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;
        login = request.getParameter("login");
        password = request.getParameter("password");
        System.out.println(login + " !!! " + password);
    }
}
