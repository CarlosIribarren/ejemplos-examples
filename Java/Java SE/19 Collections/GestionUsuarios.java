import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class GestionUsuarios {

	//Set
	private HashSet<Alumno> alumnos;
	//List
	private LinkedList<Profesor> profesores;
	//Map
	private HashMap<String, Persona> personas;
	
	public GestionUsuarios()
	{
		alumnos= new HashSet<Alumno>();
		profesores = new LinkedList<Profesor>();
		personas = new HashMap<String, Persona>();
		
	}

	public LinkedList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(LinkedList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public HashMap<String, Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(HashMap<String, Persona> personas) {
		this.personas = personas;
	}
	
	
	
	
	
}
