package com.amr.prd.product_context.presentation.rest._shared.v1.health_check;

import com.amr.cmc.common_context.bus.ApiBusController;
import com.amr.cmc.common_context.bus.command.ICommandBus;
import com.amr.cmc.common_context.bus.query.IQueryBus;
import com.amr.prd.product_context.context.shared.application.cqrs.command.status.CommandStatusCheckerCmd;
import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerQry;
import com.amr.prd.product_context.context.shared.application.cqrs.query.status.QueryStatusCheckerRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/products/health-check")
public class StatusHealthCheckController extends ApiBusController {

    public StatusHealthCheckController(IQueryBus queryBus, ICommandBus commandBus) {

        super(queryBus, commandBus);
    }

    @GetMapping("/bounded-contexts")
    public ResponseEntity<HashMap<String, String>> healthCheckBoundedContext() {

        HashMap<String, String> status = new HashMap<>();
        status.put("bounded-context", "product-context");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/commands")
    public ResponseEntity<HashMap<String, String>> healthCheckCommand() {

        dispatch(new CommandStatusCheckerCmd("product-context is up and running, health-check of command, status is ok"));
        HashMap<String, String> status = new HashMap<>();
        status.put("identity-context", "product-context");
        status.put("health-check", "commands");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/queries")
    public ResponseEntity<HashMap<String, String>> healthCheckQuery() {

        QueryStatusCheckerRes statusCheckerQueryRes = ask(new QueryStatusCheckerQry(true));
        HashMap<String, String> status = new HashMap<>();
        status.put("identity-context", "product-context");
        status.put("health-check", "queries");
        status.put("status", "ok");
        status.put("message", statusCheckerQueryRes.message());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}