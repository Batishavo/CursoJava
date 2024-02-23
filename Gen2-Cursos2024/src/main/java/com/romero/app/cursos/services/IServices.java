package com.romero.app.cursos.services;

import java.util.List;

public interface IServices<T> {
	public List<T> getAll();
	public void save(T obj);
	public T getByID(Long id);
	public void delete (Long id);
}
