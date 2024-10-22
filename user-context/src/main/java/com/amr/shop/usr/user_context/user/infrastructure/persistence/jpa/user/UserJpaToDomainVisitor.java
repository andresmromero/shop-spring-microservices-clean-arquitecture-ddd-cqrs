package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.domain.User;
import com.amr.shop.usr.user_context.user.domain.administrator.UserAdministrator;
import com.amr.shop.usr.user_context.user.domain.customer.UserCustomer;
import com.amr.shop.usr.user_context.user.domain.user_null.UserNull;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator.UserAdministatorJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer.UserCustomerJpa;
import java.util.UUID;

public class UserJpaToDomainVisitor implements UserJpaVisitor {

    private User user;

    @Override
    public void visit(UserAdministatorJpa adminJpa) {

        user = new UserAdministrator(
                adminJpa.getId(),
                adminJpa.getName(),
                adminJpa.getLastname(),
                adminJpa.getEmail(),
                adminJpa.getPassword(),
                adminJpa.getRole(),
                adminJpa.getLastConnection());
    }

    @Override
    public void visit(UserCustomerJpa customerJpa) {

        user = new UserCustomer(
                customerJpa.getId(),
                customerJpa.getName(),
                customerJpa.getLastname(),
                customerJpa.getEmail(),
                customerJpa.getPassword(),
                customerJpa.getRole(),
                customerJpa.getAddress());
    }

    @Override
    public void visit(UserNullJpa userJpa) {

        user = new UserNull(UUID.randomUUID(), "null", "null", "null@email.com", "123456789", RoleEnum.NULL);
    }

    public User getUserModel() {

        return user;
    }
}
