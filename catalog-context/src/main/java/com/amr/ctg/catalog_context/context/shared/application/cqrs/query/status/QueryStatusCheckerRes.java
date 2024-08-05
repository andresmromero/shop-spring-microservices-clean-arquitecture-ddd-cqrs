package com.amr.ctg.catalog_context.context.shared.application.cqrs.query.status;

import com.amr.cmc.common_context.bus.query.IQueryResponse;

public record QueryStatusCheckerRes(String message) implements IQueryResponse {

}