package com.example.software.model;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue
    private int admin_id;
    private int admin_salary;
    private int admin_age;
    private int employee_group;
    private String admin_name;
    private String admin_email;
    private String admin_address;
    private String admin_country;
    private String knowledge;
    private String admin_desc;


    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="admin_role_id")
    private AdminRole adminRole;


    @OneToMany(mappedBy = "admin")
    private Collection<AdminNews> adminNews;
}
