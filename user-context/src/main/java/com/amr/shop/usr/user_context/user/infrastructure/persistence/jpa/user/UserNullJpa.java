package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import java.util.UUID;

public class UserNullJpa extends UserJpa {

    public UserNullJpa() {}

    public UserNullJpa(UUID id, String name, String lastname, String email, String password, RoleEnum role) {

        super(id, name, lastname, email, password, role);
    }

    @Override
    public void accept(UserJpaVisitor visitor) {

        visitor.visit(this);
    }

    @Override
    public boolean isUserNull() {

        return true;
    }
}
