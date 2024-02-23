package com.romero.app.jpa.models;

import com.romero.app.jpa.Enums.TipoPokemon;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Poke_jpa_pokemones")
@Entity
public class Pokemon {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "POKE_SEQ4")
    @SequenceGenerator(sequenceName = "pokemon_seq5",allocationSize = 1,name =  "POKE_SEQ4")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_primario")
    private TipoPokemon tipoPrimario;

    @Column(name = "tipo_secundario")
    private TipoPokemon tipoSecundario;

    @Column(name = "altura")
    private Float altura;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "descipcion")
    private String descripcion;

    @JoinColumn(name = "estadistica_id")
    @OneToOne
    private Estadisticas estadisticas;

    @JoinColumn(name = "habilidad_id")
    @ManyToOne
    private Habilidad habilidad;

    @ManyToMany
    @JoinTable(
            name = "pokemon_movimiento",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "movimiento_id")
    )
    private List<Movimiento> movimientos;

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

    public TipoPokemon getTipoPrimario() {
        return tipoPrimario;
    }

    public void setTipoPrimario(TipoPokemon tipoPrimario) {
        this.tipoPrimario = tipoPrimario;
    }

    public TipoPokemon getTipoSecundario() {
        return tipoSecundario;
    }

    public void setTipoSecundario(TipoPokemon tipoSecundario) {
        this.tipoSecundario = tipoSecundario;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescipcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
