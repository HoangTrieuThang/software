package com.example.software.services;

import com.example.software.dto.LoginDto;
import com.example.software.model.Admin;

public interface AdminService {
    Admin login(LoginDto loginDto);
    Admin register(Admin adminRegister);
}
