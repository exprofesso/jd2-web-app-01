package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Tour;
import by.it.webapp.service.TourService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToTourListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            TourService tourService = factory.getTourService();
            List<Tour> tours = tourService.findAll();
            request.setAttribute("tours", tours);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tours.jsp");
        requestDispatcher.forward(request, response);
    }
}
