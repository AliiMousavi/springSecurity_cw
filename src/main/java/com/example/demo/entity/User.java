package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role" , discriminatorType = DiscriminatorType.STRING)
@Table(name = "users")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Column(name = "role" , insertable = false , updatable = false)
    private String role;
    private Boolean isEnabled = true;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
