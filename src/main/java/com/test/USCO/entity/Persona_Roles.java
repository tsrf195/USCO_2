package com.test.USCO.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persona_roles")
public class Persona_Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false,foreignKey = @ForeignKey(name = "fk_pr_persona"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false,foreignKey = @ForeignKey(name = "fk_pr_rol"))
    private Rol rol;
}
