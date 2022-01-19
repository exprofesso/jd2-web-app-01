package com.tc.webapp01.controller.imp;

import com.tc.webapp01.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        String surname;
        String login;
        String password;
        String address;
        String contact;


        name = request.getParameter("name");
        surname = request.getParameter("surname");
        login = request.getParameter("login");
        password = request.getParameter("password");
        address = request.getParameter("address");
        contact = request.getParameter("contact");




        System.out.println(name + " " + surname);
        System.out.println(login + " " + password);
        System.out.println(address + " " + contact);
    }
}
