package com.test.USCO.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cita_meica")
@NoArgsConstructor
public class CitaMedica {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_cita",nullable = false)
    private LocalDateTime fecha_cita;

    @ManyToOne
    @JoinColumn(name = "paciente_codigo", nullable = false)
    private Persona paciente;

    @ManyToOne
    @JoinColumn(name = "doctor_codigo", nullable = false)
    private Persona doctor;

    @ManyToOne
    @JoinColumn(name = "consultorio", nullable = false)
    private Ciudad consultorio;
}
