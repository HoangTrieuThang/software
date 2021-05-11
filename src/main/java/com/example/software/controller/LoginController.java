package com.example.software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


   @GetMapping("/")
    public String formLogin(){
   return "home-page";
   }
   @GetMapping("/restricted")
    public String restricted(){
       return "from Cao Bang with love <3 + ";
   }
}
