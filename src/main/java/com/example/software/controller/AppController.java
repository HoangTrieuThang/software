//package com.example.software.controller;
//
//import com.example.software.model.User;
//import com.example.software.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class AppController {
//
//  @Autowired
//  private UserRepository userRepository;
//
//  @GetMapping("/home-page")
//    public String homePage(){
//      return "index";
//  }
//
//  @GetMapping("/register")
//  public String showRegistrationForm(Model model) {
//    model.addAttribute("user", new User());
//    return "signup_form";
//  }
//
//  @PostMapping("/process_register")
//  public String processRegister(User user) {
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    String encodedPassword = passwordEncoder.encode(user.getUserPass());
//    user.setUserPass(encodedPassword);
//
//    userRepository.save(user);
//    return "register_success";
//  }
//
//  @GetMapping("/users")
//  public String listUsers(Model model) {
//    List<User> listUsers = userRepository.findAll();
//    model.addAttribute("listUsers", listUsers);
//    return "users";
//  }
//}
