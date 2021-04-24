package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

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
    private int admin_role_id;

    @OneToMany(mappedBy="admin_role")
    private Collection<Admin> admins;

}
