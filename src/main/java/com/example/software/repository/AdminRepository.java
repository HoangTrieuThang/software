package com.example.software.repository;

import com.example.software.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    Admin findByAdminEmail(String email);
}
