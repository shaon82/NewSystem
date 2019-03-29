package com.shaon.NHSystem.controller;


import com.shaon.NHSystem.model.Task;
import com.shaon.NHSystem.repository.TaskRepository;
import com.shaon.NHSystem.service.TaskService;
import com.shaon.NHSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session){
        session.setAttribute("email",email);
        model.addAttribute("task", new Task());
        return "view/taskform";
    }

    @PostMapping("/addTask")
    public String addtask(@Valid Task task, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            return "view/taskform";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findOneByEamil(email));
        return "redirect:/users";
    }
}
