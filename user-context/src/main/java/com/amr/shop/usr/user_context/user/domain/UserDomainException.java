package com.amr.shop.usr.user_context.user.domain;

import com.amr.shop.cmn.common_context._shared.exception.DomainException;

public class UserDomainException extends DomainException {

    public UserDomainException(String message) {

        super(message);
    }

    public UserDomainException(String message, Throwable cause) {

        super(message, cause);
    }
}
