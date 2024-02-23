package com.romero.app.jpa.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IPokmemon <T,S>{
    List<T> listar();
    Optional<T> getById(Long id);
    void guardar(S t);
    void eliminar(Long id);
}
