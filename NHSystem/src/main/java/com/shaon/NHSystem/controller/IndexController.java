package com.shaon.NHSystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {


    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String showindexpage(){
        return "index";
    }


    @GetMapping("/login")
    public String showLoginform(){
        return "view/loginform";
    }
}
