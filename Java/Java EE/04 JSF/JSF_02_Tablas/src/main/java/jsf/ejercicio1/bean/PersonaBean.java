package jsf.ejercicio1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jsf.ejercicio1.model.Persona;
 
@ManagedBean(name="personaBean")
@SessionScoped
public class PersonaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//para poder recibir los parametros del xhtml, tenemos que instanciar!!!!
	private Persona persona= new Persona();
	private List<Persona> personas;


	public PersonaBean() {
		super();
		
		personas = new ArrayList<Persona>();
		
		//relenar los datos
		
		//crear una persona
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("carlos");
		p1.setApellido("Iribarren");
		

		//crear una persona
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setNombre("David");
		p2.setApellido("Mezkiriz");
		
		personas.add(p1);
		personas.add(p2);
		
		
	}

	public String guardarPersona()
	{
		personas.add(persona);
		//despues de guardar creamos otro obj 
		//para que este disponible para poder recibir los datos
		persona = new Persona();
		
		//devolver una cadena para redirigir a la pagina
		return "ejercicio_DataTable";
	}
	
	public void eliminarPersona(Persona p)
	{
		personas.remove(p);
	}
	

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public List<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}





}