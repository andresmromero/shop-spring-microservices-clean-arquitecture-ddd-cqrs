package com.amr.shop.usr.user_context._shared.infrastructure.bus.command;

import com.amr.shop.cmn.common_context._shared.bus.command.CommandHandlerExecutionException;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommand;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommandBus;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class InMemoryCommandBus implements ICommandBus {

    private final CommandHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {

        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(ICommand command) throws CommandHandlerExecutionException {

        try {
            Class<? extends ICommandHandler> commandHandlerClass = information.search(command.getClass());

            ICommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionException(error);
        }
    }
}
