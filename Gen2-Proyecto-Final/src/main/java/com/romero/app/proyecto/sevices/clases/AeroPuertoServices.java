package com.romero.app.proyecto.sevices.clases;

import com.romero.app.proyecto.dao.IAeroPuertoDAO;
import com.romero.app.proyecto.models.AeroPuerto;
import com.romero.app.proyecto.sevices.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class AeroPuertoServices implements IService<AeroPuerto,Long> {

    @Autowired
    private IAeroPuertoDAO aeroPuertoDAO;

    @Override
    public List<AeroPuerto> listar() {

        return (List) this.aeroPuertoDAO.findAll();

    }

    @Override
    public Optional<AeroPuerto> getById(Long id) {

        return this.aeroPuertoDAO.findById(id);
    }

    @Override
    public void guardar(AeroPuerto aeroPuerto) {


            this.aeroPuertoDAO.save(aeroPuerto);



    }

    @Override
    public void eliminar(Long id) {
        this.aeroPuertoDAO.deleteById(id);
    }

    private static Float calcularDistancia() {
        // Creamos una instancia de la clase Random
        Random random = new Random();

        // Generamos un número aleatorio entre 100 y 1000 (ambos inclusive)
        float numeroAleatorio = random.nextFloat() * 900 + 100;

        return numeroAleatorio;
    }
}
