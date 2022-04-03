package by.it.webapp.controller;

import by.it.webapp.controller.imp.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    public final Map<String, Command> commandMap = new HashMap<String, Command>();
    private static final String REGISTRATION = "Registration";
    private static final String LOGIN = "login";
    private static final String GO_TO_REGISTRATION = "GoToRegistration";
    private static final String GO_TO_LOGINATION = "GoToLogination";
    private static final String GO_TO_USER_LIST = "GoToUserList";
    private static final String GO_TO_USER_EDIT = "GoToUserEdit";
    private static final String USER_SAVE_COMMAND = "UserSaveCommand";
    private static final String GO_TO_TRANSFER_SAVE_COMMAND = "GoToTransferSaveCommand";
    private static final String TRANSFER_SAVE_COMMAND = "TransferSaveCommand";
    private static final String GO_TO_TRANSFER_LIST = "GoToTransferList";
    private static final String GO_TO_TYPE_OF_HOLIDAY_SAVE_COMMAND = "GoToTypeOfHolidaySaveCommand";
    private static final String TYPE_OF_HOLIDAY_SAVE_COMMAND = "TypeOfHolidaySaveCommand";
    private static final String GO_TO_TYPE_OF_HOLIDAYS = "GoToTypeOfHolidays";
    private static final String GO_TO_DISCOUNT_SAVE_COMMAND = "GoToDiscountSaveCommand";
    private static final String DISCOUNT_SAVE_COMMAND = "DiscountSaveCommand";
    private static final String GO_TO_DISCOUNTS = "GoToDiscounts";
    private static final String GO_TO_TOUR_SAVE_COMMAND = "GoToTourSaveCommand";
    private static final String TOUR_SAVE_COMMAND = "TourSaveCommand";
    private static final String GO_TO_TOURS = "GoToTours";


    public CommandProvider() {
        commandMap.put(REGISTRATION, new RegistrationCommand());
        commandMap.put(LOGIN, new LoginationCommand());
        commandMap.put(GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commandMap.put(GO_TO_LOGINATION, new GoToLoginationCommand());
        commandMap.put(GO_TO_USER_LIST, new GoToUserListCommand());
        commandMap.put(GO_TO_USER_EDIT, new GoToUserEditCommand());
        commandMap.put(USER_SAVE_COMMAND, new UserSaveCommand());

        commandMap.put(GO_TO_TRANSFER_SAVE_COMMAND, new GoToTransferSaveCommand());
        commandMap.put(TRANSFER_SAVE_COMMAND, new TransferSaveCommand());
        commandMap.put(GO_TO_TRANSFER_LIST, new GoToTransferListCommand());

        commandMap.put(GO_TO_TYPE_OF_HOLIDAY_SAVE_COMMAND, new GoToTypeOfHolidaySaveCommand());
        commandMap.put(TYPE_OF_HOLIDAY_SAVE_COMMAND, new TypeOfHolidaySaveCommand());
        commandMap.put(GO_TO_TYPE_OF_HOLIDAYS, new GoToTypeOfHolidayListCommand());

        commandMap.put(GO_TO_DISCOUNT_SAVE_COMMAND, new GoToDiscountSaveCommand());
        commandMap.put(DISCOUNT_SAVE_COMMAND, new DiscountSaveCommand());
        commandMap.put(GO_TO_DISCOUNTS, new GoToDiscountListCommand());

        commandMap.put(GO_TO_TOUR_SAVE_COMMAND, new GoToTourSaveCommand());
        commandMap.put(TOUR_SAVE_COMMAND, new TourSaveCommand());
        commandMap.put(GO_TO_TOURS, new GoToTourListCommand());


    }

    public final Command getCommand(String commandName) {
        Command command = commandMap.get(commandName);
        return command;
    }
}
