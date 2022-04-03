package by.it.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String COMMAND = "command";
    private static final Logger log = LogManager.getLogger(Controller.class);
    public final CommandProvider commandProvider = new CommandProvider();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("role");
            if (user == null) {
                session.setAttribute("role", "Guest");
                session.setAttribute("userName", null);
                String commandName = request.getParameter("command");
                Command command = commandProvider.getCommand(commandName);
                command.execute(request, response);
            } else {
                String commandName = request.getParameter("command");
                Command command = commandProvider.getCommand(commandName);
                command.execute(request, response);
            }
        } catch (Throwable e) {
            log.error("Controller operation error", e);
        }

        String commandName = request.getParameter(COMMAND);
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);

    }

}
