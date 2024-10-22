package com.amr.shop.usr.user_context.user.domain;

import com.amr.shop.usr.user_context.user.domain.administrator.UserAdministrator;
import com.amr.shop.usr.user_context.user.domain.customer.UserCustomer;
import com.amr.shop.usr.user_context.user.domain.user_null.UserNull;

public interface UserVisitor {

    void visit(UserAdministrator admin);

    void visit(UserCustomer customer);

    void visit(UserNull userNull);
}
