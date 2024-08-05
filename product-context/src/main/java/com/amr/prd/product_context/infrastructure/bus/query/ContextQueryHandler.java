package com.amr.prd.product_context.infrastructure.bus.query;

import com.amr.cmc.common_context.bus.query.IQueryHandler;
import com.amr.cmc.common_context.bus.query.IRequestQuery;
import com.amr.cmc.common_context.bus.query.QueryNotAssignException;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Component
public class ContextQueryHandler {

    HashMap<Class<? extends IRequestQuery>, Class<? extends IQueryHandler>> indexedQueryHandlers;

    public ContextQueryHandler() {

        String path = "com.amr.prd.product_context";
        Reflections reflections = new Reflections(path);
        Set<Class<? extends IQueryHandler>> classes = reflections.getSubTypesOf(IQueryHandler.class);
        indexedQueryHandlers = formatHandlers(classes);
    }

    public Class<? extends IQueryHandler> search(Class<? extends IRequestQuery> queryClass) throws QueryNotAssignException {

        Class<? extends IQueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);
        if (null == queryHandlerClass) {
            throw new QueryNotAssignException(queryClass);
        }
        return queryHandlerClass;
    }

    private HashMap<Class<? extends IRequestQuery>, Class<? extends IQueryHandler>> formatHandlers(Set<Class<? extends IQueryHandler>> queryHandlers) {

        HashMap<Class<? extends IRequestQuery>, Class<? extends IQueryHandler>> handlers = new HashMap<>();
        for (Class<? extends IQueryHandler> handler : queryHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends IRequestQuery> queryClass = (Class<? extends IRequestQuery>) paramType.getActualTypeArguments()[0];
            handlers.put(queryClass, handler);
        }
        return handlers;
    }

}