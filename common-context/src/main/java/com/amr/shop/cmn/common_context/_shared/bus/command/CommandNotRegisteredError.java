package com.amr.shop.cmn.common_context._shared.bus.command;

import static com.amr.shop.cmn.common_context._shared.enums.ApplicationValidationEnum.COMMAND_EXCEPTION;

public class CommandNotRegisteredError extends Exception {

    public CommandNotRegisteredError(Class<? extends ICommand> command) {

        super(String.format(COMMAND_EXCEPTION.getMessage(), command.toString()));
    }
}
