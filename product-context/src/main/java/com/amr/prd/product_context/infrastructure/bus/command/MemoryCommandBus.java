package com.amr.prd.product_context.infrastructure.bus.command;

import com.amr.cmc.common_context.bus.command.CommandExecutionException;
import com.amr.cmc.common_context.bus.command.ICommandBus;
import com.amr.cmc.common_context.bus.command.ICommandHandler;
import com.amr.cmc.common_context.bus.command.IRequestCommand;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MemoryCommandBus implements ICommandBus {

    private final ContextCommandHandler information;

    private final ApplicationContext context;

    public MemoryCommandBus(ContextCommandHandler information, ApplicationContext context) {

        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(IRequestCommand requestCommand) throws CommandExecutionException {

        try {
            Class<? extends ICommandHandler> commandHandlerClass = information.search(requestCommand.getClass());
            ICommandHandler handler = context.getBean(commandHandlerClass);
            handler.handler(requestCommand);
        } catch (Throwable error) {
            throw new CommandExecutionException(error);
        }
    }

}