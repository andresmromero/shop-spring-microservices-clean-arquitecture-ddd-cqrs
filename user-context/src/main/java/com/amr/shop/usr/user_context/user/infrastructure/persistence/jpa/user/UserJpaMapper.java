package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.usr.user_context.user.domain.User;
import com.amr.shop.usr.user_context.user.domain.administrator.UserAdministrator;
import com.amr.shop.usr.user_context.user.domain.customer.UserCustomer;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator.UserAdministatorJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer.UserCustomerJpa;
import org.springframework.stereotype.Component;

@Component
public class UserJpaMapper {

    public UserJpa toJpa(UserAdministrator user) {

        return new UserAdministatorJpa(
                user.getId().getValue(),
                user.getName(),
                user.getLastname(),
                user.getEmail().getValue(),
                user.getPassword(),
                user.getRole(),
                user.getLastConnection());
    }

    public UserJpa toJpa(UserCustomer user) {

        return new UserCustomerJpa(
                user.getId().getValue(),
                user.getName(),
                user.getLastname(),
                user.getEmail().getValue(),
                user.getPassword(),
                user.getRole(),
                user.getAddress());
    }

    public User toDomain(UserAdministatorJpa user) {

        return new UserAdministrator(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getLastConnection());
    }

    public User toDomain(UserCustomerJpa user) {

        return new UserCustomer(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getAddress());
    }
}
