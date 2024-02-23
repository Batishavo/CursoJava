package com.romero.app.jpa.models;

import jakarta.persistence.*;

/**
 * Habilidades
 */
@Table(name = "Poke_jpa_Habilidades")
@Entity
public class Habilidad {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator = "POKE_SEQ1")
    @SequenceGenerator(sequenceName = "habilidades_seq",allocationSize = 1, name = "POKE_SEQ1")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}