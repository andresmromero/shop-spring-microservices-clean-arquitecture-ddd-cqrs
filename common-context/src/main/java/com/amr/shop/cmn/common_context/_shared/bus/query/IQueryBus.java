package com.amr.shop.cmn.common_context._shared.bus.query;

public interface IQueryBus {
    <R> R ask(IQuery query) throws QueryHandlerExecutionException;
}
