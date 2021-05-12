package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "admin_role")
public class AdminRole {
    @Id
    @GeneratedValue
    @Column(name = "admin_role_id")
    private Integer adminRoleId;

    @OneToMany(mappedBy="adminRole",cascade = CascadeType.ALL)
    private List<Admin> admins = new ArrayList<>();

}
