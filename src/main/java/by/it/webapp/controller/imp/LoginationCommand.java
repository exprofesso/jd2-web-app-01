package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.User;
import by.it.webapp.service.UserService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        if (login != null && password != null) {
            try {
                ServiceFactory factory = ServiceFactory.getInstance();
                UserService userService = factory.getUserService();
                User user = userService.findByLoginAndPassword(login, password);
                request.setAttribute("user", user);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("session_user", user);
                    request.setAttribute("session_user", user.getName());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorUserNotFind.jsp");
                    requestDispatcher.forward(request, response);
                }

            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            response.sendError(400);
        }
    }
}
