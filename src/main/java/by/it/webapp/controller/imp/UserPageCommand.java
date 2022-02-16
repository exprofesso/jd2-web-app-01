package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.User;
import by.it.webapp.service.UserService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            UserService userService = factory.getUserService();
            User user = userService.findByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));
            request.setAttribute("user", user);
//            request.getRequestDispatcher("/WEB-INF/jsp/user/userPage.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
        if (!request.getParameter("name").equals("")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorUserNotFind.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}


