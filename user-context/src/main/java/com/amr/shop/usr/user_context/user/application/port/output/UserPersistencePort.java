package com.amr.shop.usr.user_context.user.application.port.output;

import com.amr.shop.cmn.common_context._shared.value_object.EmailVo;
import com.amr.shop.usr.user_context.user.domain.User;

public interface UserPersistencePort {

    void createUser(User user);

    User findByEmail(EmailVo email);
}
