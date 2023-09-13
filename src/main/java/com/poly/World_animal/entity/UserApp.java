package com.poly.World_animal.entity;


import com.poly.World_animal.enums.RoleApp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_app")
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private RoleApp role;
}
