package by.it.webapp.controller;

import by.it.webapp.controller.imp.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    public final Map<String, Command> commandMap = new HashMap<String, Command>();

    public CommandProvider(){
        commandMap.put("Registration", new RegistrationCommand());
        commandMap.put("login", new LoginationCommand());
        commandMap.put("GoToRegistration", new GoToRegistrationCommand());
        commandMap.put("GoToLogination", new GoToLoginationCommand());
        commandMap.put("GoToUserList", new GoToUserListCommand());
        commandMap.put("GoToUserEdit", new GoToUserEditCommand());
        commandMap.put("UserSaveCommand", new UserSaveCommand());
        commandMap.put("GoToTransferSaveCommand", new GoToTransferSaveCommand());
        commandMap.put("TransferSaveCommand", new TransferSaveCommand());
        commandMap.put("GoToTransferList", new GoToTransferListCommand());
        commandMap.put("GoToTypeOfHolidays", new GoToTypeOfHolidayListCommand());
        commandMap.put("GoToTypeOfHolidaySaveCommand", new GoToTypeOfHolidaySaveCommand());
        commandMap.put("TypeOfHolidaySaveCommand", new TypeOfHolidaySaveCommand());





    }

    public final Command getCommand (String commandName){
        Command command = commandMap.get(commandName);
        return command;
    }
}
