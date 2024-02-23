package com.romero.app.jpa.services;

import com.romero.app.jpa.enums.Categorias;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Component
public class CategoriasService {
    public List<Categorias> getCategorias(){
        return new ArrayList<Categorias>(EnumSet.allOf(Categorias.class));
    }

}
