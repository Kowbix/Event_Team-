package com.example.Eventeam.service;

import com.example.Eventeam.entity.Match;
import com.example.Eventeam.exception.MatchNotFoundException;
import com.example.Eventeam.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<Match> getActiveMatches() {
        LocalDate date = LocalDate.now();
        List<Match> matches = matchRepository.getActiveMatches(date);

        Optional<List<Match>> activeMatches = Optional.of(matches);

        return matches;
    }

    public Match updateMatch(Match match){
        return matchRepository.save(match);
    }

    public Match findMatchById(Long id) {
        return matchRepository.findMatchById(id)
                .orElseThrow(() -> new MatchNotFoundException("Match by id " + " was not found"));
    }


}
