package com.amr.ctg.catalog_context.context.shared.application.service;

import com.amr.ctg.catalog_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QueryStatusCheckerTest {

    @Autowired
    private QueryStatusChecker useCase;

    @Test
    void checkedCommandStatus() {

        QueryStatusCheckerRes response = useCase.execute(true);
        assertEquals("catalog-context is up and running, health-check of query, status is ok", response.message());
    }

}