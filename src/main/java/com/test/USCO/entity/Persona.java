package com.test.USCO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(unique = true, name = "username", nullable = false)
    private String username;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date",nullable = false)
    private LocalDate dob;

    @Transient
    private Integer age;

    @ManyToMany
    @JoinTable(
            name = "persona_roles",
            joinColumns = @JoinColumn(
                    name = "persona_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Rol> roles = new HashSet<>();


}
