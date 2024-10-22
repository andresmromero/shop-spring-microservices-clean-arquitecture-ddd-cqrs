package com.amr.shop.usr.user_context.user.domain;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import java.util.UUID;

public abstract class ExternalUser extends User {

    protected ExternalUser(UUID id, String name, String lastname, String email, String password, RoleEnum role) {

        super(id, name, lastname, email, password, role);
    }
}
