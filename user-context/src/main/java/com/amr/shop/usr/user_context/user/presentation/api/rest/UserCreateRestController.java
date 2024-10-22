package com.amr.shop.usr.user_context.user.presentation.api.rest;

import com.amr.shop.cmn.common_context._shared.bus.command.CommandHandlerExecutionException;
import com.amr.shop.cmn.common_context._shared.bus.command.ICommandBus;
import com.amr.shop.cmn.common_context._shared.bus.query.IQueryBus;
import com.amr.shop.cmn.common_context._shared.rest.ApiController;
import com.amr.shop.usr.user_context.user.application.create.userAdministrator.CreateUserAdministratorCommand;
import com.amr.shop.usr.user_context.user.application.create.userCustomer.CreateUserCustomerCommand;
import com.amr.shop.usr.user_context.user.presentation.api.rest.user_create.request.UserAdministratorRequest;
import com.amr.shop.usr.user_context.user.presentation.api.rest.user_create.request.UserCustomerRequest;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserCreateRestController extends ApiController {

    protected UserCreateRestController(IQueryBus queryBus, ICommandBus commandBus) {

        super(queryBus, commandBus);
    }

    @PutMapping("administrators/{id}")
    public ResponseEntity<String> createUserAdministrator(
            @PathVariable String id, @RequestBody UserAdministratorRequest administrator)
            throws CommandHandlerExecutionException {

        dispatch(new CreateUserAdministratorCommand(
                UUID.fromString(id),
                administrator.getName(),
                administrator.getLastname(),
                administrator.getEmail(),
                administrator.getPassword(),
                administrator.getRole(),
                administrator.getLastConnection()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("customers/{id}")
    public ResponseEntity<String> createUserCustomer(@PathVariable String id, @RequestBody UserCustomerRequest customer)
            throws CommandHandlerExecutionException {

        dispatch(new CreateUserCustomerCommand(
                UUID.fromString(id),
                customer.getName(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getRole(),
                customer.getAddress()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
