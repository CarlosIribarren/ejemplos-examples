package es.eurohelp.cursos.springmvc.beans;

/*
 * NotEmpty to Integer is not a valid type for it to check. It's for Strings and collections. 
 * If you just want to make sure an Integer has some value, javax.validation.constraints.NotNull 
 * is all you need.
 */

public class Estudiante {

	private Integer id;
	private String nombre;
	private Integer edad;
	private String email;
	private String nif;
	
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email + ", nif=" + nif
				+ "]";
	}

	 
	   
	   
	
	
	   
}
