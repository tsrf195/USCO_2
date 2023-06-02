package com.test.USCO.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rol")
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;
}
