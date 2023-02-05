package com.example.Eventeam.controller;


import com.example.Eventeam.entity.Match;
import com.example.Eventeam.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {
    private final MatchService matchService;

    public PageController(MatchService matchService) {
        this.matchService = matchService;
    }


    @GetMapping("/")
    public String mainPage(Model model) {
        List<Match> activeMatches = matchService.getActiveMatches();
//        Optional<List<Match>> activeMatches = matchService.getActiveMatches();

        model.addAttribute("matches", activeMatches);

        return "mainPage";
    }


}
