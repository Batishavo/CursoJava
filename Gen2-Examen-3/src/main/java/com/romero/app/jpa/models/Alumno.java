package com.romero.app.jpa.models;

import jakarta.persistence.*;

@Table(name = " t_alumnos")
@Entity
public class Alumno {
    @Column(name = "id_t_usuarios")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ALUMNOS")
    @SequenceGenerator(sequenceName = "alumnos_seq",allocationSize = 1,name = "SEQ_ALUMNOS" )
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ap_paterno")
    private String apPaterno;

    @Column(name = "ap_materno")
    private String apMaterno;

    @Column(name = "activo")
    private Boolean activo;

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

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
