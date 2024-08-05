package com.amr.cmc.common_context.bus.command;

public class CommandNotAssignException extends Exception {

    public CommandNotAssignException(Class<? extends IRequestCommand> command) {

        super(String.format("The command <%s> does not have a command handler assigned", command.toString()));
    }

}