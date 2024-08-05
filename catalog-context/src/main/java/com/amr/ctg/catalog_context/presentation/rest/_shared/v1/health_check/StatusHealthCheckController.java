package com.amr.ctg.catalog_context.presentation.rest._shared.v1.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/catalogs/health-check")
public class StatusHealthCheckController {

    @GetMapping("/bounded-contexts")
    public ResponseEntity<HashMap<String, String>> healthCheckBoundedContext() {

        HashMap<String, String> status = new HashMap<>();
        status.put("bounded-context", "catalog-context");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}