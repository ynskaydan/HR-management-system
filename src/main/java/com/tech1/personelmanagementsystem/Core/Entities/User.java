package com.tech1.personelmanagementsystem.Core.Entities;

import javax.persistence.*;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)

    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @jakarta.persistence.ManyToOne()
    @jakarta.persistence.JoinColumn(name="role")
    private Role role;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;


}