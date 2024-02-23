package com.romero.app.jpa.models;

import com.romero.app.jpa.Enums.TipoPokemon;
import jakarta.persistence.*;

@Table(name = "Poke_jpa_Movimientos")
@Entity
public class Movimiento {

    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POKE_SEQ2")
    @SequenceGenerator(sequenceName = "movimiento_seq2",allocationSize = 1,name = "POKE_SEQ2" )
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private TipoPokemon tipo;

    @Column(name = "descripcion")
    private String descipcion;

    @Column(name = "poder")
    private Integer poder;

    @Column(name = "precicion")
    private Integer precision;

    @Column(name = "pp")
    private Integer PP;

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

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getPP() {
        return PP;
    }

    public void setPP(Integer PP) {
        this.PP = PP;
    }
}
