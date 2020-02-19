package pakete;

//------ EJEMPLO ----------- 
//CLASE SIN AMBITO : SOLO SE PUEDE ACEDER A ELLA SI ESTAMOS EN
//DENTRO DEL MISMO PAKETE

class Persona {

	String nombre;
	String apellido;
	
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
}
