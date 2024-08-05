package com.amr.cmc.common_context.bus.command;

public interface ICommandHandler<T extends IRequestCommand> {

    void handler(T command);

}