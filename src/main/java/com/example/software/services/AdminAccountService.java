package com.example.software.services;

import com.example.software.model.Admin;
import com.example.software.model.NewsKind;

import java.util.List;

public interface AdminAccountService {
    List<Admin> getAll();
    Admin findAdminByAdminId (Integer id);

    Admin create(Admin admin);

    Admin update(Integer id, Admin admin) throws Exception;

    void delete(Integer id);
}
