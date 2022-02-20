package by.it.webapp.controller.imp;

import by.it.webapp.controller.Command;
import by.it.webapp.domain.Transfer;
import by.it.webapp.service.TransferService;
import by.it.webapp.util.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToTransferListCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            TransferService transferService = factory.getTransferService();
            List<Transfer> transfers = transferService.findAll();
            request.setAttribute("transfers", transfers);
        } catch (Exception e){
            throw new ServletException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/transfers.jsp");
        requestDispatcher.forward(request, response);
    }
}
