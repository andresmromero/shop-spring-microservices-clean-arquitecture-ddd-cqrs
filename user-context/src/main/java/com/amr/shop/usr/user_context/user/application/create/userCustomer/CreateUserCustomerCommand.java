package com.amr.shop.usr.user_context.user.application.create.userCustomer;

import com.amr.shop.cmn.common_context._shared.bus.command.ICommand;
import com.amr.shop.cmn.common_context.token.RoleEnum;
import java.util.UUID;

public record CreateUserCustomerCommand(
        UUID id, String name, String lastName, String email, String password, RoleEnum roleEnum, String address)
        implements ICommand {}
