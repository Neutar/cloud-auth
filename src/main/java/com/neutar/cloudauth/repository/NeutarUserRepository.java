package com.neutar.cloudauth.repository;

import com.neutar.cloudauth.domain.NeutarUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NeutarUserRepository extends JpaRepository<NeutarUser, UUID> {
    Optional<NeutarUser> findByUsername(String username);
}
