package com.test.USCO.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ciudad")
@NoArgsConstructor
public class Ciudad{
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "dep_codigo", nullable = false)
    private Departamento departamento;

}
