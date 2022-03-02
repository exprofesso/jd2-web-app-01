package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Tour;
import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.TourService;
import by.it.webapp.service.TransferService;
import by.it.webapp.service.TypeOfHolidayService;
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
            TypeOfHolidayService typeOfHolidayService = factory.getTypeOfHolidayService();
            TransferService transferService = factory.getTransferService();
            List<Tour> tours = tourService.findAll();
            List<TypeOfHoliday> typeOfHolidays = typeOfHolidayService.findAll();
            List<Transfer> transfers = transferService.findAll();


            for (Tour tour : tours) {
                TypeOfHoliday typeOfHoliday = new TypeOfHoliday();
                Transfer trans = new Transfer();
                for (TypeOfHoliday holiday : typeOfHolidays) {
                    if (holiday.getId().equals(tour.getTypeOfHoliday().getId())) {
                        typeOfHoliday.setTypeOfHoliday(holiday.getTypeOfHoliday());
                        typeOfHoliday.setId(tour.getTypeOfHoliday().getId());
                        tour.setTypeOfHoliday(typeOfHoliday);
                    }
                }
                for (Transfer transfer : transfers) {
                    if (transfer.getId().equals(tour.getTransfer().getId())) {
                        trans.setTypeOfTransport(transfer.getTypeOfTransport());
                        trans.setId(tour.getTransfer().getId());
                        tour.setTransfer(trans);
                    }
                }
            }
            request.setAttribute("tours", tours);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tours.jsp");
        requestDispatcher.forward(request, response);
    }
}
