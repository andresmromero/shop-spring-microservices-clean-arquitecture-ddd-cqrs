package com.amr.shop.cmn.common_context._shared.bus.command;

public interface ICommandHandler<T extends ICommand> {
    void handle(T command);
}
