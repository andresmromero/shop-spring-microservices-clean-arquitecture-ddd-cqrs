package com.amr.shop.usr.user_context.user.application.create;

import com.amr.shop.cmn.common_context._shared.enums.ApplicationValidationEnum;
import com.amr.shop.cmn.common_context._shared.value_object.EmailVo;
import com.amr.shop.cmn.common_context.token.RoleEnum;
import com.amr.shop.usr.user_context.user.application.port.output.UserPersistencePort;
import com.amr.shop.usr.user_context.user.domain.UserEmailAlreadyExistException;
import com.amr.shop.usr.user_context.user.domain.administrator.UserAdministrator;
import com.amr.shop.usr.user_context.user.domain.customer.UserCustomer;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {

    private final UserPersistencePort userPersistencePort;

    public UserCreator(UserPersistencePort userPersistencePort) {

        this.userPersistencePort = userPersistencePort;
    }

    public void createUserAdministrator(
            UUID id, String name, String lastName, String email, String password, RoleEnum role, Date lastConnection) {

        ensureEmailExists(new EmailVo(email));
        UserAdministrator user = UserAdministrator.create(id, name, lastName, email, password, role, lastConnection);
        this.userPersistencePort.createUser(user);
    }

    public void createUserCustomer(
            UUID id, String name, String lastname, String email, String password, RoleEnum roleEnum, String address) {

        ensureEmailExists(new EmailVo(email));
        UserCustomer customer = UserCustomer.create(id, name, lastname, email, password, roleEnum, address);

        this.userPersistencePort.createUser(customer);
    }

    private void ensureEmailExists(EmailVo email) {

        if (!this.userPersistencePort.findByEmail(email).isUserNull()) {
            throw new UserEmailAlreadyExistException(ApplicationValidationEnum.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }
}
