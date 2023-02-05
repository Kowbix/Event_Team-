package com.example.Eventeam.controller;

import com.example.Eventeam.entity.*;
import com.example.Eventeam.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/configure")
public class SetUpMatchController {
    private final SetUpMatchService setUpMatchService;
    private final MatchService matchService;
    private final TaskService taskService;
    private final UserService userService;


    public SetUpMatchController(SetUpMatchService setUpMatchService, MatchService matchService,
                                TaskService taskService, UserService userService) {
        this.setUpMatchService = setUpMatchService;
        this.matchService = matchService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String addTaskToMatch(@RequestParam Long matchId, Model model) {
        Match match = matchService.findMatchById(matchId);

        List<Task> tasksAssigned = setUpMatchService.getTaskAssignedToMatch(matchId);
        List<Task> tasks = taskService.getTasksWithoutMatch(tasksAssigned);

        List<User> users = userService.getAllUsers();

        model.addAttribute("match", match);
        model.addAttribute("tasks", tasks);
        model.addAttribute("users", users);

        return "matchConfigure/addtasktomatch";
    }

    @PostMapping("/save")
    public String saveSetUp(@RequestParam Long matchId, Long taskId, Long userId) {
        Match match = matchService.findMatchById(matchId);
        Task task = taskService.findTaskById(taskId);
        User user = userService.findUserById(userId);


        setUpMatchService.saveSetUpToDB(new MatchToTaskToUser(match, task, user));


        return "redirect:/match/all";
    }

    @GetMapping("/match")
    public String getTasksByMatchId(@RequestParam Long id, Model model) {
        List<MatchToTaskToUser> tasks = setUpMatchService.getSetUpByMatchId(id);
        String match = tasks.get(0).getMatch().getName();

        model.addAttribute("tasks", tasks);
        model.addAttribute("match", match);

        return "matchConfigure/matchConfig";
    }

}
