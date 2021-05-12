package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_pass;
    private int user_phone;
    private String user_address;
    private Date user_birth;
    private boolean enable;
//    @Enumerated(EnumType.STRING)
//    private AuthenticationProvider auth_provider;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Collection<History> histories;


}
