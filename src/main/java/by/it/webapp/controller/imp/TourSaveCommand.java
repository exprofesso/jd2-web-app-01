package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Food;
import by.it.webapp.domain.Tour;
import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.TourService;
import by.it.webapp.service.TransferService;
import by.it.webapp.service.TypeOfHolidayService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class TourSaveCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tour tour = new Tour();
        TypeOfHoliday typeOfHoliday = new TypeOfHoliday();
        Transfer transfer = new Transfer();

        try {
            tour.setId(Long.parseLong(request.getParameter("id")));
        } catch (NumberFormatException e) {
        }
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            TourService tourService = factory.getTourService();
            TypeOfHolidayService typeOfHolidayService = factory.getTypeOfHolidayService();
            TransferService transferService = factory.getTransferService();

//            typeOfHoliday = typeOfHolidayService.findByType(request.getParameter("typeOfHoliday"));
//
//            if (!typeOfHoliday.getTypeOfHoliday().equals("null")) {
//                tour.setTypeOfHoliday(typeOfHoliday);
//            }
//            typeOfHoliday.setTypeOfHoliday(request.getParameter("typeOfHoliday"));
            tour.setTown(request.getParameter("town"));
            tour.setDate(Date.valueOf(request.getParameter("date")));
            tour.setDay(Integer.parseInt(request.getParameter("day")));
            tour.setFood(Food.values()[Integer.parseInt(request.getParameter("food"))]);
            tour.setPrice(Integer.parseInt(request.getParameter("price")));
            transfer = transferService.findByType(request.getParameter("transfer"));
            if (!transfer.getTypeOfTransport().equals("null")) {
                tour.setTransfer(transfer);
            }
            tourService.save(tour);

        } catch (Exception e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/tour/list.html");

    }
}
