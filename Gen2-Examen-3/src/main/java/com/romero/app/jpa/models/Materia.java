package com.romero.app.jpa.models;

import jakarta.persistence.*;

@Table(name = "t_materias")
@Entity
public class Materia {

    @Column(name = "id_t_materias")
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator = "cust_materias")
    @SequenceGenerator(sequenceName = "materias_seq",allocationSize = 1,name = "cust_materias")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name ="activo")
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
