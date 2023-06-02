package com.test.USCO.entity;

import javax.persistence.*;

@Entity
@Table(name = "consultorios")
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

}
