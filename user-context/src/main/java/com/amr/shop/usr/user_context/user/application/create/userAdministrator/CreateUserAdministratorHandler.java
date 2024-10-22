package com.amr.shop.usr.user_context.user.application.create.userAdministrator;

import com.amr.shop.cmn.common_context._shared.bus.command.ICommandHandler;
import com.amr.shop.usr.user_context.user.application.create.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdministratorHandler implements ICommandHandler<CreateUserAdministratorCommand> {

    private final UserCreator userCreator;

    @Autowired
    public CreateUserAdministratorHandler(UserCreator userCreator) {

        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserAdministratorCommand command) {

        userCreator.createUserAdministrator(
                command.id(),
                command.name(),
                command.lastName(),
                command.email(),
                command.password(),
                command.role(),
                command.lastConnection());
    }
}
