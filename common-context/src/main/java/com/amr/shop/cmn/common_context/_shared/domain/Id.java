package com.amr.shop.cmn.common_context._shared.domain;

import java.util.Objects;

public abstract class Id<T> {

    private final T value;

    public T getValue() {

        return value;
    }

    protected Id(T value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id<?> id = (Id<?>) o;
        return Objects.equals(value, id.value);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(value);
    }
}
