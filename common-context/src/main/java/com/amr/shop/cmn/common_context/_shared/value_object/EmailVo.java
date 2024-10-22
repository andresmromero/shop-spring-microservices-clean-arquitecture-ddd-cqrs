package com.amr.shop.cmn.common_context._shared.value_object;

import com.amr.shop.cmn.common_context._shared.enums.ValidationVoEnum;
import java.util.Objects;
import java.util.regex.Pattern;

public class EmailVo {

    private final String value;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public EmailVo(String value) {

        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(ValidationVoEnum.EMAIL_ERROR.getMessage());
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
        EmailVo emailVo = (EmailVo) o;
        return Objects.equals(value, emailVo.value);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(value);
    }

    @Override
    public String toString() {

        return "Email{value='" + value + "'}";
    }
}
