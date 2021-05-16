package com.example.software.services.impl;

import com.example.software.dto.LoginDto;
import com.example.software.model.Admin;
import com.example.software.repository.AdminRepository;
import com.example.software.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin login(LoginDto loginDto) {

        Admin admin = adminRepository.findByAdminEmail(loginDto.getEmail());
        if(admin != null) {
            if(admin.getPassword().equals(loginDto.getPassword())) {
                return admin;
            }
        }
        return null;
    }
    public Admin register(Admin adminRegister) {
       return adminRepository.save(adminRegister);
    }
}
