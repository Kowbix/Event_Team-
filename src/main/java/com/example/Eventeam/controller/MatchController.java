package com.example.Eventeam.controller;


import com.example.Eventeam.entity.Match;
import com.example.Eventeam.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/all")
    public String getAllMatches(Model model) {
        List<Match> matches = matchService.getAllMatches();
        model.addAttribute("matches", matches);
        return "matches/allmatches";
    }

    @GetMapping("/add")
    public String returnAddMatch() {
        return "matches/addmatch";
    }

    @PostMapping("/save")
    public String addMatch(@ModelAttribute Match match) {
        matchService.addMatch(match);
        return "redirect:/match/all";
    }

    @GetMapping("/edit")
    public String getEditMatch(@RequestParam Long id, Model model) {
        Match match = matchService.findMatchById(id);
        model.addAttribute("match", match);
        return "matches/editingmatch";
    }

    @PostMapping("saveChange")
    public String saveChange(@ModelAttribute Match match) {
        matchService.updateMatch(match);
        return "redirect:/match/all";
    }
}
