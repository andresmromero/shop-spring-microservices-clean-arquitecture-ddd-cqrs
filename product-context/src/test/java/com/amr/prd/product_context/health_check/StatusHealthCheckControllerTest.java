package com.amr.prd.product_context.health_check;

import com.amr.cmc.common_context.bus.command.ICommandBus;
import com.amr.cmc.common_context.bus.query.IQueryBus;
import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerQry;
import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;
import com.amr.prd.product_context.presentation.rest._shared.v1.health_check.StatusHealthCheckController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class StatusHealthCheckControllerTest {

    @InjectMocks
    private StatusHealthCheckController statusHealthCheckController;

    private MockMvc mockMvc;

    @Mock
    private IQueryBus queryBus;

    @Mock
    private ICommandBus commandBus;

    @BeforeEach
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(statusHealthCheckController).build();
    }

    @Test
    void shouldHealthCheckReturnStatusOkWithBody() throws Exception {

        String url = "/api/v1/products/health-check/bounded-contexts";
        HashMap<String, String> expectedStatus = new HashMap<>();
        expectedStatus.put("bounded-context", "product-context");
        expectedStatus.put("status", "ok");
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedStatusJson = objectMapper.writeValueAsString(expectedStatus);
        MockHttpServletResponse response = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
                                                  .andExpect(status().isOk())
                                                  .andReturn()
                                                  .getResponse();
        String actualResponseBody = response.getContentAsString();
        assertEquals(expectedStatusJson, actualResponseBody);
    }


    @Test
    void shouldHealthCheckCommandReturnStatusOkWithBody() throws Exception {

        String url = "/api/v1/products/health-check/commands";
        HashMap<String, String> expectedStatus = new HashMap<>();
        expectedStatus.put("identity-context", "product-context");
        expectedStatus.put("health-check", "commands");
        expectedStatus.put("status", "ok");
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedStatusJson = objectMapper.writeValueAsString(expectedStatus);
        MockHttpServletResponse response = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
                                                  .andExpect(status().isOk())
                                                  .andReturn()
                                                  .getResponse();
        String actualResponseBody = response.getContentAsString();
        assertEquals(expectedStatusJson, actualResponseBody);
    }

    @Test
    void shouldHealthCheckQueryReturnStatusOkWithBody() throws Exception {

        String url = "/api/v1/products/health-check/queries";
        QueryStatusCheckerRes statusCheckerQueryRes = new QueryStatusCheckerRes(
                "product-context is up and running, health-check of query, status is ok");
        when(queryBus.ask(any(QueryStatusCheckerQry.class))).thenReturn(statusCheckerQueryRes);
        HashMap<String, String> expectedStatus = new HashMap<>();
        expectedStatus.put("identity-context", "product-context");
        expectedStatus.put("health-check", "queries");
        expectedStatus.put("status", "ok");
        expectedStatus.put("message", statusCheckerQueryRes.message());
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedStatusJson = objectMapper.writeValueAsString(expectedStatus);
        MockHttpServletResponse response = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
                                                  .andExpect(status().isOk())
                                                  .andReturn()
                                                  .getResponse();
        String actualResponseBody = response.getContentAsString();
        assertEquals(expectedStatusJson, actualResponseBody);
        verify(queryBus).ask(any(QueryStatusCheckerQry.class));
    }
}