package com.amr.shop.usr.user_context.user.presentation.api.rest;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserRestController {

    @PostMapping
    public ResponseEntity<HashMap<String, String>> createUser() {

        log.debug("user-context - status ok");
        HashMap<String, String> status = new HashMap<>();
        status.put("bounded_context", "user-context");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
