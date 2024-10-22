package com.amr.shop.usr.user_context.user.domain.user_null;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.domain.User;
import com.amr.shop.usr.user_context.user.domain.UserVisitor;
import java.util.UUID;

public class UserNull extends User {

    public UserNull(UUID id, String name, String lastname, String email, String password, RoleEnum role) {

        super(id, name, lastname, email, password, role);
    }

    @Override
    public void accept(UserVisitor visitor) {

        visitor.visit(this);
    }

    @Override
    public boolean isUserNull() {

        return true;
    }
}
