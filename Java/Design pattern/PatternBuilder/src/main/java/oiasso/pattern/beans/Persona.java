package oiasso.pattern.beans;

public class Persona {

    private String email;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

	
	public Persona() {
	}


	/**
	 * Get the field email
	 * 
	 * @return Return the field email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Set the value email
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Get the field nombre
	 * 
	 * @return Return the field nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Set the value nombre
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Get the field apellidos
	 * 
	 * @return Return the field apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * Set the value apellidos
	 *
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * Get the field telefono
	 * 
	 * @return Return the field telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * Set the value telefono
	 *
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * Get the field direccion
	 * 
	 * @return Return the field direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * Set the value direccion
	 *
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

	
	
	
}
