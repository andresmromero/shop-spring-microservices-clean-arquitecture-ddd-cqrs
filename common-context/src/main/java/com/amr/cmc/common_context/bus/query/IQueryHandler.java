package com.amr.cmc.common_context.bus.query;

public interface IQueryHandler<Q extends IRequestQuery, R extends IQueryResponse> {

    R handle(Q query);

}