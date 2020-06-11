package oiasso.system.examples.security.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.system.examples.security.daos.NotaDao;
import oiasso.system.examples.security.entitys.Nota;
import oiasso.system.examples.security.facades.NotaFacade;

@Service
public class NotaFacadeImpl implements NotaFacade {

	@Autowired
	private NotaDao notaDao; 
	
	@Override
	public List<Nota> getAll() {
		return notaDao.findAll();
	}

}
