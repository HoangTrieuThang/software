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
    private int admin_role_id;

    @OneToMany(mappedBy="adminRole",cascade = CascadeType.ALL)
    private List<Admin> admins = new ArrayList<>();

}
