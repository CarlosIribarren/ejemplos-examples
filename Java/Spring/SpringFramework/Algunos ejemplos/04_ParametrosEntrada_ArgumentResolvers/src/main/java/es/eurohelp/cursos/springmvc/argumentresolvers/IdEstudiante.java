package es.eurohelp.cursos.springmvc.argumentresolvers;

import java.io.Serializable;

public class IdEstudiante implements Serializable {
	
	//******************
	//*** CONSTANTES ***
	//******************
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int id;	
	private int ejercicio;
	
	public IdEstudiante(){
	}	
	
	public IdEstudiante(int ejercicio, int id){
		this.id = id; 
		this.ejercicio = ejercicio;		
	}
		
	/**
	 * Obtiene el campo id
	 * @return Campo id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el campo id
	 * @param id campo id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene el campo ejercicio
	 * @return Campo ejercicio
	 */
	public int getEjercicio() {
		return ejercicio;
	}
	/**
	 * Establece el campo ejercicio
	 * @param ejercicio campo ejercicio a establecer
	 */
	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}

}
