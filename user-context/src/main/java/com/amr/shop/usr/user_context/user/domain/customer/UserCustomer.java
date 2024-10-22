package com.amr.shop.usr.user_context.user.domain.customer;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.domain.ExternalUser;
import com.amr.shop.usr.user_context.user.domain.UserVisitor;
import java.util.UUID;

public class UserCustomer extends ExternalUser {

    private String address;

    public UserCustomer(
            UUID id, String name, String lastname, String email, String password, RoleEnum role, String address) {

        super(id, name, lastname, email, password, role);
        this.address = address;
    }

    public static UserCustomer create(
            UUID id, String name, String lastname, String email, String password, RoleEnum roleEnum, String address) {

        return new UserCustomer(id, name, lastname, email, password, roleEnum, address);
    }

    public String getAddress() {

        return address;
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
