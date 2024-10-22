package com.amr.shop.cmn.common_context._shared.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {

        super(message);
    }

    public DomainException(String message, Throwable cause) {

        super(message, cause);
    }
}
