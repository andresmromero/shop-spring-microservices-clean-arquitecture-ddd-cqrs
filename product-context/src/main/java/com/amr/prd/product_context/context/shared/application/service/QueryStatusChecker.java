package com.amr.prd.product_context.context.shared.application.service;

import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;
import com.amr.prd.product_context.context.shared.application.port.input.IQueryStatusCheckerPort;
import org.springframework.stereotype.Service;

@Service
public class QueryStatusChecker implements IQueryStatusCheckerPort {

    public QueryStatusCheckerRes execute(boolean status) {

        return new QueryStatusCheckerRes("product-context is up and running, health-check of query, status is " + (
                status
                        ? "ok"
                        : "fail"));
    }

}