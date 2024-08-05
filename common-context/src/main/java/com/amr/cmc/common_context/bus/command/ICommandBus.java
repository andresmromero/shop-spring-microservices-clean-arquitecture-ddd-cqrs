package com.amr.cmc.common_context.bus.command;

public interface ICommandBus {

    void dispatch(IRequestCommand requestCommand) throws CommandExecutionException;

}