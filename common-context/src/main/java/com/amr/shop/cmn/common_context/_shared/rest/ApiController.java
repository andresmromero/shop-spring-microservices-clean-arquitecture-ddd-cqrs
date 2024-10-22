package com.amr.shop.cmn.common_context._shared.rest;

import com.amr.shop.cmn.common_context._shared.bus.command.CommandHandlerExecutionException;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommand;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommandBus;
import com.amr.shop.cmn.common_context._shared.bus.query.IQuery;
import com.amr.shop.cmn.common_context._shared.bus.query.IQueryBus;
import com.amr.shop.cmn.common_context._shared.bus.query.QueryHandlerExecutionException;

public abstract class ApiController {

    private final IQueryBus queryBus;

    private final ICommandBus commandBus;

    protected ApiController(IQueryBus queryBus, ICommandBus commandBus) {

        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(ICommand command) throws CommandHandlerExecutionException {

        commandBus.dispatch(command);
    }

    protected <R> R ask(IQuery query) throws QueryHandlerExecutionException {

        return queryBus.ask(query);
    }
}
