package com.amr.ctg.catalog_context.infrastructure.bus.command;

import com.amr.cmc.common_context.bus.command.CommandNotAssignException;
import com.amr.cmc.common_context.bus.command.ICommandHandler;
import com.amr.cmc.common_context.bus.command.IRequestCommand;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Component
public class ContextCommandHandler {

    HashMap<Class<? extends IRequestCommand>, Class<? extends ICommandHandler>> indexedCommandHandlers;

    public ContextCommandHandler() {

        String path = "com.amr.ctg.catalog_context";
        Reflections reflections = new Reflections(path);
        Set<Class<? extends ICommandHandler>> classes = reflections.getSubTypesOf(ICommandHandler.class);
        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends ICommandHandler> search(Class<? extends IRequestCommand> commandClass) throws CommandNotAssignException {

        Class<? extends ICommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);
        if (null == commandHandlerClass) {
            throw new CommandNotAssignException(commandClass);
        }
        return commandHandlerClass;
    }

    private HashMap<Class<? extends IRequestCommand>, Class<? extends ICommandHandler>> formatHandlers(Set<Class<? extends ICommandHandler>> commandHandlers) {

        HashMap<Class<? extends IRequestCommand>, Class<? extends ICommandHandler>> handlers = new HashMap<>();
        for (Class<? extends ICommandHandler> handler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends IRequestCommand> commandClass = (Class<? extends IRequestCommand>) paramType.getActualTypeArguments()[0];
            handlers.put(commandClass, handler);
        }
        return handlers;
    }

}