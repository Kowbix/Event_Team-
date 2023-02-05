package com.example.Eventeam.controller;

import com.example.Eventeam.entity.Task;
import com.example.Eventeam.entity.User;
import com.example.Eventeam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("user", users);
        return "users/allusers";
    }

    @GetMapping("/add")
    public String returnAddUser() {
        return "users/adduser";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user){
        userService.addUser(new User(user.getName(), user.getSurname(), user.getMail(), user.getPhoneNumber()));
        return "redirect:/user/all";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/user/all";
    }

    @GetMapping("/edit")
    public String getEditUser(@RequestParam Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "users/editinguser";
    }

    @PostMapping("/saveChange")
    public String saveChange(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/user/all";
    }

}
