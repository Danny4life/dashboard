package com.osiki.dashboardapplication.repository;

import com.osiki.dashboardapplication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByLoginAndPassword(String login, String password);
    Optional<UserModel> findFirstByLogin(String login);
}
