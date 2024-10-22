package com.amr.shop.usr.user_context.user.application.create.userAdministrator;

import com.amr.shop.cmn.common_context._shared.bus.command.ICommand;
import com.amr.shop.cmn.common_context.token.RoleEnum;
import java.util.Date;
import java.util.UUID;

public record CreateUserAdministratorCommand(
        UUID id, String name, String lastName, String email, String password, RoleEnum role, Date lastConnection)
        implements ICommand {}
