package com.example.software.services.impl;

import com.example.software.model.Admin;
import com.example.software.model.NewsKind;
import com.example.software.repository.AdminAccountRepository;
import com.example.software.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminAccountServiceImpl implements AdminAccountService {
    @Autowired
    private AdminAccountRepository adminAccountRepository;

    @Override
    public List<Admin> getAll() {
        return adminAccountRepository.findAll();
    }

    @Override
    public Admin findAdminByAdminId(Integer id) {
        return adminAccountRepository.findAllByAdminId(id);
    }

    @Override
    public Admin create(Admin admin) {
        return adminAccountRepository.save(admin);
    }

    @Override
    @Transactional
    public Admin update(Integer id, Admin admin) throws Exception {
        Admin admin1 = adminAccountRepository.findAllByAdminId(id);
        if (admin1 ==null) {
            throw new Exception("abc");
        }
        admin1.setAdminEmail(admin.getAdminEmail());
        admin1.setPassword(admin.getPassword());
        admin1.setAdminAddress(admin.getAdminAddress());
        admin1.setAdminName(admin.getAdminName());
        return adminAccountRepository.save(admin1);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        adminAccountRepository.deleteByAdminId(id);
    }
}
