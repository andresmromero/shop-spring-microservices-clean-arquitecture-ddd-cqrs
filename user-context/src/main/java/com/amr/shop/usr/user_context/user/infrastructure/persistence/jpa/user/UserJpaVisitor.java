package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator.UserAdministatorJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer.UserCustomerJpa;

public interface UserJpaVisitor {

    void visit(UserAdministatorJpa adminJpa);

    void visit(UserCustomerJpa customerJpa);

    void visit(UserNullJpa userJpa);
}
