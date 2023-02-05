package com.example.Eventeam.repository;

import com.example.Eventeam.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskById(Long id);
}
