package com.example.software.model;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "admin",uniqueConstraints={@UniqueConstraint(columnNames = {"admin_email"})})
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_email")
    private String adminEmail;
    @Column(name = "password")
    private String password;
    @Column(name = "admin_address")
    private String adminAddress;
    @Column(name = "admin_desc")
    private String adminDesc;
    @Column(name = "create_at")
    private Date createdAt;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminEmail, String password, String adminAddress, String adminDesc, Date createdAt) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.password = password;
        this.adminAddress = adminAddress;
        this.adminDesc = adminDesc;
        this.createdAt = createdAt;
    }


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminDesc() {
        return adminDesc;
    }

    public void setAdminDesc(String adminDesc) {
        this.adminDesc = adminDesc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }
}
