package com.amr.shop.cmn.common_context.user;

import com.amr.shop.cmn.common_context._shared.domain.Id;
import java.util.UUID;

public class UserId extends Id<UUID> {

    public UserId(UUID value) {

        super(value);
    }
}
