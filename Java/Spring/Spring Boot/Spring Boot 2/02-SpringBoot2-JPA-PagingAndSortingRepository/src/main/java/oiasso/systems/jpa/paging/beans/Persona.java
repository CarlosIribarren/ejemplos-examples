package oiasso.systems.jpa.paging.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prueba")
public class Persona {

	// *********************
	// ***** Atributos *****
	// *********************

	/** Id */
	@Id
	private Integer id;

	/** Nombre */
	private String nombre;

	/** Fecha de nacimiento */
	private LocalDate fecha;

	// *********************
	// **** Constructor ****
	// *********************

	/** Constructor sin parametros */
	public Persona() {
		super();
	}

	// *********************
	// ** Getter y Setter **
	// *********************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
