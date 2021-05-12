package com.example.software.services;

import com.example.software.model.AuthenticationProvider;
import com.example.software.model.User;
import com.example.software.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Service(value= "userService")
public class UserService {

    @Autowired
    private UserRepository repo;

    public void processOAuthPostLogin(String user_name) {
        User existUser = repo.getUserByUsername(user_name);

//        if (existUser == null) {
//            User user = new User();
//            user.setUserName(user_name);
//            user.setAuth_provider(AuthenticationProvider.GOOGLE);
//            user.setEnable(true);
//
//            repo.save(user);
//        }

    }

}
