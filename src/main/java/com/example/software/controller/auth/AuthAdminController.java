package com.example.software.controller.auth;

import com.example.software.dto.LoginDto;
import com.example.software.model.Admin;
import com.example.software.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"})
public class AuthAdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody LoginDto loginDto) {
    Admin admin =adminService.login(loginDto);
    if(admin != null){
        admin.setPassword("");
        return ResponseEntity.status(200).body(admin);
    }
    return ResponseEntity.status(202).body(null);
}
    @PostMapping("/register")
    public ResponseEntity<Admin> register(@RequestBody Admin registerAdmin) {
        Admin admin =adminService.register(registerAdmin);
        if(admin != null){
            admin.setPassword("");
            return ResponseEntity.status(200).body(admin);
        }
        return ResponseEntity.status(202).body(null);
    }



}
