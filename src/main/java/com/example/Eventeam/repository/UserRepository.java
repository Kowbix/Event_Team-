package com.example.Eventeam.repository;

import com.example.Eventeam.entity.Task;
import com.example.Eventeam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}
