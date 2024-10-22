package com.amr.shop.cmn.common_context._shared.bus.query;

import com.amr.shop.cmn.common_context._shared.enums.ApplicationValidationEnum;

public final class QueryNotRegisteredError extends Exception {

    public QueryNotRegisteredError(Class<? extends IQuery> query) {

        super(String.format(ApplicationValidationEnum.QUERY_EXCEPTION.getMessage(), query.toString()));
    }
}
