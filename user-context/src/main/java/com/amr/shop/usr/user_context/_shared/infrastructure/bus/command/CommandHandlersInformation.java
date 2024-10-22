package com.amr.shop.usr.user_context._shared.infrastructure.bus.command;

import com.amr.shop.cmn.common_context._shared.bus.command.CommandNotRegisteredError;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommand;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommandHandler;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

@Component
public final class CommandHandlersInformation {

    HashMap<Class<? extends ICommand>, Class<? extends ICommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {

        Reflections reflections = new Reflections("com.amr.shop.usr.user_context.*");
        Set<Class<? extends ICommandHandler>> classes = reflections.getSubTypesOf(ICommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends ICommandHandler> search(Class<? extends ICommand> commandClass)
            throws CommandNotRegisteredError {

        Class<? extends ICommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends ICommand>, Class<? extends ICommandHandler>> formatHandlers(
            Set<Class<? extends ICommandHandler>> commandHandlers) {

        HashMap<Class<? extends ICommand>, Class<? extends ICommandHandler>> handlers = new HashMap<>();

        for (Class<? extends ICommandHandler> handler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends ICommand> commandClass =
                    (Class<? extends ICommand>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
