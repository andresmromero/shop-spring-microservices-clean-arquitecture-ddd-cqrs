package com.amr.ctg.catalog_context.context.shared.application.port.input;

import com.amr.ctg.catalog_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;

public interface IQueryStatusCheckerPort {

    QueryStatusCheckerRes execute(boolean status);

}