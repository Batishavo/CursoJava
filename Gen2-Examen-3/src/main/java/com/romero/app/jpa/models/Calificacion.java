package com.romero.app.jpa.models;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "t_calificaciones")
@Entity
public class Calificacion {

    @Column(name = "id_t_calificaciones")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cust_calificaciones")
    @SequenceGenerator(sequenceName = "calificaciones_seq",allocationSize = 1 ,name = "cust_calificaciones")
    private Long id;

    @JoinColumn(name = "id_t_materias")
    @ManyToOne
    private Materia materia;

    @JoinColumn(name = "id_t_usuarios")
    @ManyToOne
    private Alumno alumno;

    @Column(name = "calificacion")
    private Float calificacion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
