package com.amr.cmc.common_context.bus.query;

public class QueryNotAssignException extends Exception {

    public QueryNotAssignException(Class<? extends IRequestQuery> query) {

        super(String.format("The query <%s> does not have a query handler assigned", query.toString()));
    }

}