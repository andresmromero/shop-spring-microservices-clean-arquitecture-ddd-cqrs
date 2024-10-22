package com.amr.shop.usr.user_context.user.domain;

import com.amr.shop.cmn.common_context._shared.exception.DomainException;

public class UserEmailAlreadyExistException extends DomainException {

    public UserEmailAlreadyExistException(String message) {

        super(message);
    }

    public UserEmailAlreadyExistException(String message, Throwable cause) {

        super(message, cause);
    }
}
