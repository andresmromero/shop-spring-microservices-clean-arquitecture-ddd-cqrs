package com.amr.ctg.catalog_context.infrastructure.bus.query;

import com.amr.cmc.common_context.bus.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ContextQueryBus implements IQueryBus {

    private final ContextQueryHandler information;

    private final ApplicationContext context;

    public ContextQueryBus(ContextQueryHandler information, ApplicationContext context) {

        this.information = information;
        this.context = context;
    }

    @Override
    public IQueryResponse ask(IRequestQuery requestQuery) throws QueryHandlerExecutionException {

        try {
            Class<? extends IQueryHandler> queryHandlerClass = information.search(requestQuery.getClass());
            IQueryHandler handler = context.getBean(queryHandlerClass);
            return handler.handle(requestQuery);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionException(error);
        }
    }

}