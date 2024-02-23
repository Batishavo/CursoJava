package com.romero.app.proyecto.models;

import jakarta.persistence.*;

@Table(name = "aero_puerto")
@Entity
public class AeroPuerto {

    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AERO_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_AERO",allocationSize = 1,name = "AERO_SEQ" )
    private Long id;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "nombre")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
