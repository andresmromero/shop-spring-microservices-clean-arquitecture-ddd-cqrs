package com.amr.shop.usr.user_context._shared.infrastructure.bus.query;

import com.amr.shop.cmn.common_context._shared.bus.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class InMemoryQueryBus implements IQueryBus {

    private final QueryHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {

        this.information = information;
        this.context = context;
    }

    @Override
    public IResponse ask(IQuery query) throws QueryHandlerExecutionException {

        try {
            Class<? extends IQueryHandler> queryHandlerClass = information.search(query.getClass());

            IQueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionException(error);
        }
    }
}
