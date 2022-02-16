//package by.it.webapp.controller.imp;
//
//import by.it.webapp.controller.Command;
//import by.it.webapp.domain.User;
//import by.it.webapp.service.UserService;
//import by.it.webapp.util.ServiceFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class UserListCommand implements Command {
//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            ServiceFactory factory = ServiceFactory.getInstance();
//            UserService userService = factory.getUserService();
//            List<User> users = userService.findAll();
//            request.setAttribute("users", users);
////            request.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(request, response);
//
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
//}
