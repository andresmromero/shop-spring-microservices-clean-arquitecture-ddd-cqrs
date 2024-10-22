package com.amr.shop.cmn.common_context.token;

import java.util.Set;

public enum RoleEnum {
    ADMIN(Set.of(PermissionEnum.ADMIN_READ)),
    CUSTOMER(Set.of(PermissionEnum.CUSTOMER_READ)),
    NULL(Set.of(PermissionEnum.NULL));

    RoleEnum(Set<PermissionEnum> permissions) {

        this.permissions = permissions;
    }

    private final Set<PermissionEnum> permissions;

    public Set<PermissionEnum> getPermissions() {

        return permissions;
    }
}
