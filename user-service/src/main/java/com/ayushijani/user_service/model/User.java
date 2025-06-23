package com.ayushijani.user_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),          // Column in join table referring to User
            inverseJoinColumns = @JoinColumn(name = "roles_role_name")  // Column referring to Role
    )
    private Set<Role> roles;

}
