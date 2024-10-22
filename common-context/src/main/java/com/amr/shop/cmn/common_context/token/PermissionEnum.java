package com.amr.shop.cmn.common_context.token;

public enum PermissionEnum {
    ADMIN_READ("admin:read"),
    CUSTOMER_READ("customer:read"),
    NULL("null");

    private final String permission;

    PermissionEnum(String permission) {

        this.permission = permission;
    }

    public String getPermission() {

        return permission;
    }
}
