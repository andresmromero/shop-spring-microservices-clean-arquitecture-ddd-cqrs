package com.amr.cmc.common_context.bus;

import com.amr.cmc.common_context.bus.command.ICommandBus;
import com.amr.cmc.common_context.bus.command.IRequestCommand;
import com.amr.cmc.common_context.bus.query.IQueryBus;
import com.amr.cmc.common_context.bus.query.IRequestQuery;
import com.amr.cmc.common_context.exception.DomainException;

public class ApiBusController {

    private final IQueryBus queryBus;

    private final ICommandBus commandBus;

    public ApiBusController(IQueryBus queryBus, ICommandBus commandBus) {

        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(IRequestCommand requestCommand) throws DomainException {

        commandBus.dispatch(requestCommand);
    }

    protected <R> R ask(IRequestQuery requestQuery) throws DomainException {

        return queryBus.ask(requestQuery);
    }

}