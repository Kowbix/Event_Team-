package com.example.Eventeam.controller;


import com.example.Eventeam.entity.Task;
import com.example.Eventeam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks/alltasks";
    }

    @GetMapping("/add")
    public String returnAddTask() {
        return "tasks/addtask";
    }

    @PostMapping("/save")
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(new Task(task.getName(), task.getDescription()));
        return "redirect:/task/all";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
        return "redirect:/task/all";
    }

    @GetMapping("/edit")
    public String getEditTask(@RequestParam Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "tasks/editingtask";
    }

    @PostMapping("/saveChange")
    public String saveChange(@ModelAttribute Task task) {
        taskService.updateTask(task);
        return "redirect:/task/all";
    }
}
