package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.cmn.common_context._shared.value_object.EmailVo;
import com.amr.shop.usr.user_context.user.application.port.output.UserPersistencePort;
import com.amr.shop.usr.user_context.user.domain.User;
import com.amr.shop.usr.user_context.user.domain.UserVisitor;
import com.amr.shop.usr.user_context.user.domain.administrator.UserAdministrator;
import com.amr.shop.usr.user_context.user.domain.customer.UserCustomer;
import com.amr.shop.usr.user_context.user.domain.user_null.UserNull;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator.UserAdministatorJpa;
import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer.UserCustomerJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJpaPersistenceAdapter implements UserPersistencePort, UserVisitor {

    private final UserRepository userRepository;

    private final UserAdministratorRepository adminRepository;

    private final UserCustomerRepository customerRepository;

    private final UserJpaMapper userJpaMapper;

    @Autowired
    public UserJpaPersistenceAdapter(
            UserRepository userRepository,
            UserAdministratorRepository adminRepository,
            UserCustomerRepository customerRepository,
            UserJpaMapper userJpaMapper) {

        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public void createUser(User user) {

        user.accept(this);
    }

    @Override
    public void visit(UserAdministrator admin) {

        adminRepository.save((UserAdministatorJpa) userJpaMapper.toJpa(admin));
    }

    @Override
    public void visit(UserCustomer customer) {

        customerRepository.save((UserCustomerJpa) userJpaMapper.toJpa(customer));
    }

    @Override
    public void visit(UserNull userNull) {}

    @Override
    public User findByEmail(EmailVo email) {

        UserJpa userJpa = userRepository.findByEmail(email.getValue()).orElse(new UserNullJpa());
        UserJpaToDomainVisitor visitor = new UserJpaToDomainVisitor();
        userJpa.accept(visitor);
        return visitor.getUserModel();
    }
}
