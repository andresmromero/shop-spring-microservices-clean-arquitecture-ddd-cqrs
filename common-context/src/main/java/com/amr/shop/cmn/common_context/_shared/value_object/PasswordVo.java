package com.amr.shop.cmn.common_context._shared.value_object;

import static com.amr.shop.cmn.common_context._shared.enums.ValidationVoEnum.PASSWORD_MINIMUM_LENGTH_ERROR;

import java.util.Objects;

public class PasswordVo {

    private final String value;

    public PasswordVo(String value) {

        if (value == null || value.length() <= 8) {
            throw new IllegalArgumentException(PASSWORD_MINIMUM_LENGTH_ERROR.getMessage());
        }
        this.value = value;
    }

    public String getValue() {

        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordVo that = (PasswordVo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(value);
    }

    @Override
    public String toString() {

        return "Password{value='" + value + "'}";
    }
}
