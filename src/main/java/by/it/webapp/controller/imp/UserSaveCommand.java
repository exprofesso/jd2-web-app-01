package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Discount;
import by.it.webapp.domain.Role;
import by.it.webapp.domain.User;
import by.it.webapp.service.UserService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSaveCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        try {
            user.setId(Long.parseLong(request.getParameter("id")));
        } catch (NumberFormatException e) {
        }
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            user.setLogin(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));
            if (!request.getParameter("name").equals("")) {
                user.setName(request.getParameter("name"));
            } else {
                user.setName("null");
            }
            if (!request.getParameter("surname").equals("")) {
                user.setSurname(request.getParameter("surname"));
            } else {
                user.setSurname("null");
            }
            if (!request.getParameter("email").equals("")) {
                user.setEmail(request.getParameter("email"));
            } else {
                user.setEmail("null");
            }
            Discount discount = new Discount();
            discount.setPercent(2);
//            discount.setPercent(Integer.parseInt(request.getParameter("discount")));
            user.setDiscount(discount);
            Role role = new Role(1);
            user.setRole(role);
            userService.save(user);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp");
        requestDispatcher.forward(request, response);

//        HttpSession httpSession = request.getSession(false);
//        if (httpSession.getAttribute("session_user") == null) {
//            response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/logination.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath() + "/orderList.jsp");
//        }
    }
}
