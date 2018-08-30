package com.barterownia.repository;

import com.barterownia.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findAppUserByUsername(String username);

    List<AppUser> findAllByUsernameContaining(String username);

    Optional<AppUser> findByPassword(String code);
}
