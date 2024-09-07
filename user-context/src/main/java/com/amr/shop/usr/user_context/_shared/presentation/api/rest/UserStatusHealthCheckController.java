package com.amr.shop.usr.user_context._shared.presentation.api.rest;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health-check")
public class UserStatusHealthCheckController {

    @GetMapping("bounded-contexts")
    public ResponseEntity<HashMap<String, String>> healthCheck() {

        HashMap<String, String> status = new HashMap<>();
        status.put("bounded_context", "user-context");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
