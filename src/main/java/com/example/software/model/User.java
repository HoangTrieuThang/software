package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_pass")
    private String userPass;
    @Column(name="user_phone")
    private int userPhone;
    @Column(name="user_address")
    private String userAddress;
    @Column(name="user_birth")
    private Date userBirth;
    @Column(name="enable")
    private boolean enable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;


}
