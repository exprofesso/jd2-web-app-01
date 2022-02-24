package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Discount;
import by.it.webapp.service.DiscountService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DiscountSaveCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discount discount = new Discount();
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            DiscountService discountService = serviceFactory.getDiscountService();
            discount.setPercent(Integer.parseInt(request.getParameter("Percent")));
            discountService.save(discount);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
