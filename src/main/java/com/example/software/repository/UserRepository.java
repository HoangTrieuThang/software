package com.example.software.repository;

import com.example.software.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User u WHERE u.userName = :username")
    public User getUserByUsername(@Param("username") String username);
}
