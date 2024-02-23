package com.romero.app.proyecto.models;


import com.romero.app.proyecto.utils.enums.Sexo;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "piloto")
public class Piloto {
    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PILOTO_SEQ")
    @SequenceGenerator(sequenceName = "PILOTO_VUELO",allocationSize = 1,name = "PILOTO_SEQ" )
    private Long id;

    @Column(name = "codigo")
    private String codigol;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "sexo")
    private Sexo sexo;

    @Column(name = "horas_acumuladas")
    private Float horasAcumuladas;

    public String getCodigol() {
        return codigol;
    }

    public void setCodigol(String codigol) {
        this.codigol = codigol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Float getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(Float horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
