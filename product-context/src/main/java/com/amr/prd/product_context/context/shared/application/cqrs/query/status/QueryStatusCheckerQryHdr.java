package com.amr.prd.product_context.context.shared.application.cqrs.query.status;

import com.amr.cmc.common_context.bus.query.IQueryHandler;
import com.amr.prd.product_context.context.shared.application.service.QueryStatusChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryStatusCheckerQryHdr implements IQueryHandler<QueryStatusCheckerQry, QueryStatusCheckerRes> {

    private final QueryStatusChecker useCase;

    @Autowired
    public QueryStatusCheckerQryHdr(QueryStatusChecker useCase) {

        this.useCase = useCase;
    }

    @Override
    public QueryStatusCheckerRes handle(QueryStatusCheckerQry query) {

        return useCase.execute(query.status());
    }

}