package com.amr.shop.usr.user_context._shared.presentation.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserStatusHealthCheckController.class)
class UserStatusHealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldHealthCheckReturnStatusOkWithBody() throws Exception {

        String url = "/users/api/v1/health-check/bounded-contexts";
        HashMap<String, String> expectedStatus = new HashMap<>();
        expectedStatus.put("bounded_context", "user-context");
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
}
