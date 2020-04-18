package oiasso.systems.rest.api.model;

public class Persona {

	// *********************
	// ***** Atributos *****
	// *********************

	/** Id */
	private Integer id;

	/** Nombre */	
	private String nombre;

	/** Apellido */
	private String apellido;

	// *********************
	// **** Constructor ****
	// *********************

	/** Constructor sin parametros */
	public Persona() {
		super();
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param id Id
	 * @param nombre Nombre 
	 * @param apellido Apellido
	 */
	public Persona(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
