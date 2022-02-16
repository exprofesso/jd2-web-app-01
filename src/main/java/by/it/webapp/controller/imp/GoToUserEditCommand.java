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

public class GoToUserEditCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = null;

        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException e) {
        }

        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            UserService userService = factory.getUserService();
            User user = userService.findById(id);
            request.setAttribute("user", user);

        } catch (Exception e) {
            throw new ServletException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userEdit.jsp");
        requestDispatcher.forward(request, response);
    }
}

