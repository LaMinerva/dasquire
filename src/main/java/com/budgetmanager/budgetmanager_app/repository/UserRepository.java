package com.budgetmanager.budgetmanager_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetmanager.budgetmanager_app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByCodiceFiscale(String codiceFiscale);
    boolean existsByAliasNickname(String alias);
    Optional<User> findByEmail(String email);
    Optional<User> findByAliasNickname(String alias);
}
