package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserJpa {

    @Id
    private UUID id;

    private String name;

    private String lastname;

    private String email;

    private String password;

    private RoleEnum role;

    protected UserJpa() {}

    protected UserJpa(UUID id, String name, String lastname, String email, String password, RoleEnum role) {

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public abstract void accept(UserJpaVisitor visitor);

    public UUID getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getLastname() {

        return lastname;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    public RoleEnum getRole() {

        return role;
    }

    public abstract boolean isUserNull();
}
