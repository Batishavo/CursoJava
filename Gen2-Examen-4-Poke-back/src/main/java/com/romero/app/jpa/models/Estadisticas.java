package com.romero.app.jpa.models;

import jakarta.persistence.*;

@Table(name = "Poke_jpa_estadisticas")
@Entity
public class Estadisticas {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "POKE_SEQ3")
    @SequenceGenerator(sequenceName = "estadisticas_seq3",allocationSize = 1,name = "POKE_SEQ3")
    private Long id;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "defensa_especial")
    private Integer defensaEspecial;

    @Column(name = "defensa")
    private Integer defensa;

    @Column(name = "ataque")
    private Integer ataque;

    @Column(name = "ataqueEspecial")
    private Integer ataqueEspecial;

    @Column(name = "velocidad")
    private Integer velocidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(Integer defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(Integer ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }
}
