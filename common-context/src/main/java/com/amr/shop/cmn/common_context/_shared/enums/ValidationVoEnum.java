package com.amr.shop.cmn.common_context._shared.enums;

public enum ValidationVoEnum {
    EMAIL_ERROR("Email is not valid"),
    PASSWORD_MINIMUM_LENGTH_ERROR("Password must be valid");

    private final String message;

    ValidationVoEnum(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
