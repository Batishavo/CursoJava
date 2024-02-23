package com.romero.app.proyecto.sevices.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService <T,S>{
    List<T> listar();
    Optional<T> getById(Long id);
    void guardar(T t);
    void eliminar(S id);
}
