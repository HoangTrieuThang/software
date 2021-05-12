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
    @Column(name="gender_id")
    private int genderId;
    @Column(name="gender_name")
    private String genderName;

    @OneToMany(mappedBy = "gender")
    private Collection<User> users;

    @OneToMany(mappedBy="gender")
    private Collection<Admin> admins;
}
