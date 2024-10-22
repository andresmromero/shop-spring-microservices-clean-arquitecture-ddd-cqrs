package com.amr.shop.usr.user_context.user.infrastructure.persistence.jpa.user;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpa, UUID> {

    Optional<UserJpa> findByEmail(String email);
}
