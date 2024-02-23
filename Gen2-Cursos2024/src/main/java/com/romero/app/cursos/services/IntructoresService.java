package com.romero.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.romero.app.cursos.dao.IIntructoresDAO;
import com.romero.app.cursos.models.Instructor;

@Component
public class IntructoresService implements IServices<Instructor> {
	
	@Autowired
	private IIntructoresDAO intructoresDao;
	
	@Override
	public List<Instructor> getAll() {
		// TODO Auto-generated method stub
		return (List<Instructor>)intructoresDao.findAll();
	}

	@Override
	public void save(Instructor obj) {
		// TODO Auto-generated method stub
		intructoresDao.save(obj);
	}

	@Override
	public Instructor getByID(Long id) {
		// TODO Auto-generated method stub
		return intructoresDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		intructoresDao.deleteById(id);
	}



}
