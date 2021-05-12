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
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "admin_salary")
    private Integer adminSalary;
    @Column(name = "admin_age")
    private Integer adminAge;
    @Column(name = "employee_group")
    private Integer employeeGroup;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_email")
    private String adminEmail;
    @Column(name = "admin_address")
    private String adminAddress;
    @Column(name = "admin_country")
    private String adminCountry;
    @Column(name = "knowledge")
    private String knowledge;
    @Column(name = "admin_desc")
    private String adminDesc;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="admin_role_id")
    private AdminRole adminRole;


//    @OneToMany(mappedBy = "admin")
//    private Collection<AdminNews> adminNews;
}
