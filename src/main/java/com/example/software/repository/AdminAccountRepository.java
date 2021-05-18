package com.example.software.repository;

import com.example.software.model.Admin;
import com.example.software.model.NewsKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminAccountRepository extends JpaRepository<Admin,Integer> {

    @Override
    List<Admin> findAll();
    Admin findAllByAdminId(Integer adminId);
    void deleteByAdminId(int id);
}
