package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Discount;
import by.it.webapp.domain.Role;
import by.it.webapp.domain.User;
import by.it.webapp.service.UserService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
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
            discount.setPercent(Integer.parseInt(request.getParameter("discount")));
            user.setDiscount(discount);
            Role role = new Role();
            role.setRoleId(Integer.parseInt(request.getParameter("role")));
            user.setRole(role);
            userService.save(user);

        } catch (Exception e) {
            throw new ServletException(e);
        }



//        String name;
//        String surname;
//        String login;
//        String password;
//        String address;
//        String contact;
//
//
//        name = request.getParameter("name");
//        surname = request.getParameter("surname");
//        login = request.getParameter("login");
//        password = request.getParameter("password");
//        address = request.getParameter("address");
//        contact = request.getParameter("contact");
//
//
//
//
//        System.out.println(name + " " + surname);
//        System.out.println(login + " " + password);
//        System.out.println(address + " " + contact);
//
        response.getWriter().println(user.toString());
//
//
////        response.getWriter().println("GAF GAF GAF");
    }
}
