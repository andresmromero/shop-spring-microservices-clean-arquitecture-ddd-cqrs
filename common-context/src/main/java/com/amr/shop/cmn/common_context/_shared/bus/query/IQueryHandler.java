package com.amr.shop.cmn.common_context._shared.bus.query;

public interface IQueryHandler<Q extends IQuery, R extends IResponse> {
    R handle(Q query);
}
