package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userCustomer.UserCustomerJpa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCustomerRepository extends JpaRepository<UserCustomerJpa, UUID> {}
