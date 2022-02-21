package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.TypeOfHolidayService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TypeOfHolidaySaveCommand implements Command {
    TypeOfHoliday typeOfHoliday = new TypeOfHoliday();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            TypeOfHolidayService typeOfHolidayService = serviceFactory.getTypeOfHolidayService();
            typeOfHoliday.setTypeOfHoliday(request.getParameter("typeOfHoliday"));
            typeOfHolidayService.save(typeOfHoliday);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
