package com.amr.shop.usr.user_context.user.presentation.api.rest.user_create.request;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class UserRequest {

    private final String name;

    private final String lastname;

    private final String email;

    private final String password;

    private final RoleEnum role;
}
