package com.amr.shop.usr.user_context._shared.infrastructure.bus.query;

import com.amr.shop.cmn.common_context._shared.bus.query.IQuery;
import com.amr.shop.cmn.common_context._shared.bus.query.IQueryHandler;
import com.amr.shop.cmn.common_context._shared.bus.query.QueryNotRegisteredError;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

@Component
public final class QueryHandlersInformation {

    HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {

        Reflections reflections = new Reflections("com.amr.shop.usr.user_context.*");
        Set<Class<? extends IQueryHandler>> classes = reflections.getSubTypesOf(IQueryHandler.class);

        indexedQueryHandlers = formatHandlers(classes);
    }

    public Class<? extends IQueryHandler> search(Class<? extends IQuery> queryClass) throws QueryNotRegisteredError {

        Class<? extends IQueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

    private HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> formatHandlers(
            Set<Class<? extends IQueryHandler>> queryHandlers) {

        HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> handlers = new HashMap<>();

        for (Class<? extends IQueryHandler> handler : queryHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends IQuery> queryClass =
                    (Class<? extends IQuery>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }
}
