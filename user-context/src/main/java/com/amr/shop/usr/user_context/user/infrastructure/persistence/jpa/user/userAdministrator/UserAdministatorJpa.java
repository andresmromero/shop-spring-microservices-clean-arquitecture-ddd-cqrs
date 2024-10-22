package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.UserJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.UserJpaVisitor;
import jakarta.persistence.Entity;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class UserAdministatorJpa extends UserJpa {

    private Date lastConnection;

    public UserAdministatorJpa() {}

    public UserAdministatorJpa(Date lastConnection) {

        this.lastConnection = lastConnection;
    }

    public UserAdministatorJpa(
            UUID id, String name, String lastname, String email, String password, RoleEnum role, Date lastConnection) {

        super(id, name, lastname, email, password, role);
        this.lastConnection = lastConnection;
    }

    public Date getLastConnection() {

        return lastConnection;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAdministatorJpa that = (UserAdministatorJpa) o;
        return Objects.equals(lastConnection, that.lastConnection);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(lastConnection);
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
