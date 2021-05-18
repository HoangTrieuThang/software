package com.example.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    //http://localhost:8080/login/oauth2/code/google
    //link login

    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @GetMapping("/welcome")
    public String hello() {
        return "login success";
    }

}
