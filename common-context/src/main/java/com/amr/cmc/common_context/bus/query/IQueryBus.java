package com.amr.cmc.common_context.bus.query;

public interface IQueryBus {

    <R> R ask(IRequestQuery requestQuery) throws QueryHandlerExecutionException;

}