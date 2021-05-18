package com.example.software.repository;

import com.example.software.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<Admin,Integer> {
}
