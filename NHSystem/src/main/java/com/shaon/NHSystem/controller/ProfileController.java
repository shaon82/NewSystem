package com.shaon.NHSystem.controller;


import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.service.TaskService;
import com.shaon.NHSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @GetMapping("/profile")
    public String showprofile(Model model, Principal principal){
        String email= principal.getName();
        User user = userService.findOneByEamil(email);
        model.addAttribute("tasks",taskService.findUserByTask(user));
        return "view/profile";
    }
}
