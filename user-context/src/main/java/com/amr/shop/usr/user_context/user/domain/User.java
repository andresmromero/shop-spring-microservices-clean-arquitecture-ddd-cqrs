package com.amr.shop.usr.user_context.user.domain;

import com.amr.shop.cmn.common_context._shared.domain.AggregateRoot;
import com.amr.shop.cmn.common_context._shared.value_object.EmailVo;
import com.amr.shop.cmn.common_context._shared.value_object.PasswordVo;
import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.cmn.common_context.user.UserId;
import java.util.UUID;

public abstract class User extends AggregateRoot<UserId> {

    private final String name;

    private final String lastname;

    private final EmailVo email;

    private final PasswordVo password;

    private final RoleEnum role;

    protected User(UUID id, String name, String lastname, String email, String password, RoleEnum role) {

        super.setId(new UserId(id));
        this.name = name;
        this.lastname = lastname;
        this.email = new EmailVo(email);
        this.password = new PasswordVo(password);
        this.role = role;
    }

    public String getName() {

        return name;
    }

    public String getLastname() {

        return lastname;
    }

    public EmailVo getEmail() {

        return email;
    }

    public RoleEnum getRole() {

        return role;
    }

    public String getPassword() {

        return password.getValue();
    }

    public abstract void accept(UserVisitor visitor);

    public abstract boolean isUserNull();
}
