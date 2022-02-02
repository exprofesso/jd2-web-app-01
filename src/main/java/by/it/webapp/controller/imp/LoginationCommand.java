package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;

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

        response.getWriter().println("You login " + login + " " + "Password " + password);
    }
}
