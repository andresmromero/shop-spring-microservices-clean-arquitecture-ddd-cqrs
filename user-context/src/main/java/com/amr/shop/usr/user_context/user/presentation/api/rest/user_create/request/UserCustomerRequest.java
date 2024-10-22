package com.amr.shop.usr.user_context.user.presentation.api.rest.user_create.request;

import com.amr.shop.cmn.common_context.token.RoleEnum;

public class UserCustomerRequest extends UserRequest {

    private String address;

    public UserCustomerRequest(
            String name, String lastname, String email, String password, RoleEnum role, String address) {

        super(name, lastname, email, password, role);
        this.address = address;
    }

    public String getAddress() {

        return address;
    }
}
