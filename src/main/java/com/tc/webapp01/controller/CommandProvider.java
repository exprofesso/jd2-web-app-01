package com.tc.webapp01.controller;

import com.tc.webapp01.controller.imp.GoToLoginationCommand;
import com.tc.webapp01.controller.imp.GoToRegistrationCommand;
import com.tc.webapp01.controller.imp.LoginationCommand;
import com.tc.webapp01.controller.imp.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    public final Map<String, Command> commandMap = new HashMap<String, Command>();

    public CommandProvider(){
        commandMap.put("Registration", new RegistrationCommand());
        commandMap.put("login", new LoginationCommand());
        commandMap.put("GoToRegistration", new GoToRegistrationCommand());
        commandMap.put("GoToLogination", new GoToLoginationCommand());

    }

    public final Command getCommand (String commandName){
        Command command = commandMap.get(commandName);
        return command;
    }
}
