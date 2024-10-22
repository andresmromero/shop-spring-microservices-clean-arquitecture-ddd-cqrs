package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.UserJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.UserJpaVisitor;
import jakarta.persistence.Entity;
import java.util.Objects;
import java.util.UUID;

@Entity
public class UserCustomerJpa extends UserJpa {

    private String address;

    public UserCustomerJpa() {}

    public UserCustomerJpa(String address) {

        this.address = address;
    }

    public UserCustomerJpa(
            UUID id, String name, String lastname, String email, String password, RoleEnum role, String address) {

        super(id, name, lastname, email, password, role);
        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCustomerJpa that = (UserCustomerJpa) o;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(address);
    }

    @Override
    public void accept(UserJpaVisitor visitor) {

        visitor.visit(this);
    }

    @Override
    public boolean isUserNull() {

        return false;
    }
}
