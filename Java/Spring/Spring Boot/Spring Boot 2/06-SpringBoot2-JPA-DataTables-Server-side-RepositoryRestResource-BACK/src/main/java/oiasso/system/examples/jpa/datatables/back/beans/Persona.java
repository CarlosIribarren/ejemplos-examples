package oiasso.system.examples.jpa.datatables.back.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fecha;

	// *********************
	// **** Constructor ****
	// *********************

	/** Constructor sin parametros */
	public Persona() {
		super();
	}

	public Persona(Integer id, String nombre, LocalDate fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
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
