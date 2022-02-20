package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Transfer;
import by.it.webapp.service.TransferService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferSaveCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transfer transfer = new Transfer();
//
//        try {
//            transfer.setId(Long.parseLong(request.getParameter("id")));
//        } catch (NumberFormatException e) {
//        }
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            TransferService transferService = serviceFactory.getTransferService();
            transfer.setTypeOfTransport(request.getParameter("typeOfTransport"));
            transferService.save(transfer);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
