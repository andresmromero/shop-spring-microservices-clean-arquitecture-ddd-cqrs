package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user.userAdministrator.UserAdministatorJpa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdministratorRepository extends JpaRepository<UserAdministatorJpa, UUID> {}
