package com.example.Eventeam.repository;

import com.example.Eventeam.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findMatchById(Long id);

    @Query("FROM Match M WHERE M.date>=?1")
    List<Match> getActiveMatches(LocalDate date);
}
