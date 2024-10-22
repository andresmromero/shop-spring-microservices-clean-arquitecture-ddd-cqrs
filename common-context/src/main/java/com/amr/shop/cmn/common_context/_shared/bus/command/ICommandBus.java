package com.amr.shop.cmn.common_context._shared.bus.command;

public interface ICommandBus {
    void dispatch(ICommand command) throws CommandHandlerExecutionException;
}
