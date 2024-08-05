package com.amr.ctg.catalog_context.context.shared.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class CommandStatusCheckerTest {

    @Autowired
    private CommandStatusChecker useCase;

    @Test
    void shouldExecuteDoesNotThrow() {

        assertDoesNotThrow(() -> useCase.execute("message"));
    }

}