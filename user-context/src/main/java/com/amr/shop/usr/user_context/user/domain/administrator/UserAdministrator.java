package com.amr.shop.usr.user_context.user.domain.administrator;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.domain.UserSystem;
import com.amr.shop.usr.user_context.user.domain.UserVisitor;
import java.util.Date;
import java.util.UUID;

public class UserAdministrator extends UserSystem {

    private final Date lastConnection;

    public UserAdministrator(
            UUID id, String name, String lastname, String email, String password, RoleEnum role, Date lastConnection) {

        super(id, name, lastname, email, password, role);
        this.lastConnection = lastConnection;
    }

    public static UserAdministrator create(
            UUID id, String name, String lastName, String email, String password, RoleEnum role, Date lastConnection) {

        return new UserAdministrator(id, name, lastName, email, password, role, lastConnection);
    }

    public Date getLastConnection() {

        return lastConnection;
    }

    @Override
    public void accept(UserVisitor visitor) {

        visitor.visit(this);
    }

    @Override
    public boolean isUserNull() {

        return false;
    }
}
