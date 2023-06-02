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
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "dep_codigo", nullable = false)
    private Departamento departamento;

}
