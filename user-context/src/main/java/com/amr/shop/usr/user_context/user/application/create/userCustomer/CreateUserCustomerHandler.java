package com.amr.shop.usr.user_context.user.application.create.userCustomer;

import com.amr.shop.cmn.common_context._shared.bus.command.ICommandHandler;
import com.amr.shop.usr.user_context.user.application.create.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCustomerHandler implements ICommandHandler<CreateUserCustomerCommand> {

    private final UserCreator userCreator;

    @Autowired
    public CreateUserCustomerHandler(UserCreator userCreator) {

        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserCustomerCommand command) {

        userCreator.createUserCustomer(
                command.id(),
                command.name(),
                command.lastName(),
                command.email(),
                command.password(),
                command.roleEnum(),
                command.address());
    }
}
