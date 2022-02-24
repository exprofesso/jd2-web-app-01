package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Discount;
import by.it.webapp.service.DiscountService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToDiscountListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            DiscountService discountService = factory.getDiscountService();
            List<Discount> discounts = discountService.findAll();
            request.setAttribute("discounts", discounts);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/discounts.jsp");
        requestDispatcher.forward(request, response);
    }
}

