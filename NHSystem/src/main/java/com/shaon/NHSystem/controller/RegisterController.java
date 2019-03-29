package com.shaon.NHSystem.controller;


import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerform(Model model){
        model.addAttribute("user", new User());
        return "view/registerform";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "view/registerform";
        }
        if (userService.isUserpresent(user.getEmail())){
            model.addAttribute("exist", true);
            return "view/registerform";
        }
        userService.createUser(user);
        return "view/success";
    }
}
