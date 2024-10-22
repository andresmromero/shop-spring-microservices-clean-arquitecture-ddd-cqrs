package com.amr.shop.usr.user_context.user.presentation.api.rest.user_create.request;

import com.amr.shop.cmn.common_context.token.RoleEnum;
import java.util.Date;

public class UserAdministratorRequest extends UserRequest {

    private Date lastConnection;

    public UserAdministratorRequest(
            String name, String lastname, String email, String password, RoleEnum role, Date lastConnection) {

        super(name, lastname, email, password, role);
        this.lastConnection = lastConnection;
    }

    public Date getLastConnection() {

        return lastConnection;
    }
}
