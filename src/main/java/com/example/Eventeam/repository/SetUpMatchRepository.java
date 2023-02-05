package com.example.Eventeam.repository;

import com.example.Eventeam.entity.MatchToTaskToUser;
import com.example.Eventeam.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SetUpMatchRepository extends JpaRepository<MatchToTaskToUser, Long> {

    @Query("SELECT ud from connectdata ud where ud.match.id=?1")
    List<MatchToTaskToUser> getTasksByMatchId(Long id);
}
