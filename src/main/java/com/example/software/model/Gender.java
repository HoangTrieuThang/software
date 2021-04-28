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
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue
    private int gender_id;
    private String gender_name;

    @OneToMany(mappedBy = "gender")
    private Collection<User> users;

    @OneToMany(mappedBy="gender")
    private Collection<Admin> admins;
}
