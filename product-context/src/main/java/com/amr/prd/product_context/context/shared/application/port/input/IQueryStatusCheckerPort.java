package com.amr.prd.product_context.context.shared.application.port.input;

import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;

public interface IQueryStatusCheckerPort {

    QueryStatusCheckerRes execute(boolean status);

}