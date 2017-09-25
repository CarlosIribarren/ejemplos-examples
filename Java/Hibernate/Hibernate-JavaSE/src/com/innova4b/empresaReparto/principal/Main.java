package com.innova4b.empresaReparto.principal;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.innova4b.empresaReparto.hibernateUtil.HibernateUtil;
import com.innova4b.empresaReparto.persistent.Empleado;

public class Main {

	public static void main(String[] args) {

		//creamos un instacia de la clase
		Main m = new Main();

		m.insertEmpleado();
		
		HibernateUtil.getSessionFactory().close();
		
		
	}
	
	private void insertEmpleado()
	{
		Empleado e = new Empleado();
		e.setNombre("Carlos");
		e.setFechaNacimiento(new Date());
		
		//Crear la factoria
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//Empezar Transacion
		session.beginTransaction();
		

		//e.setJefe(null);
		
		//el metodo save persiste el objeto, devuelve el identificador del objeto
		session.save(e);
		
		
		//commit
		session.getTransaction().commit();
	}

}
