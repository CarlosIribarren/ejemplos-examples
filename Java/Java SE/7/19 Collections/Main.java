import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// SET : No puede haber valores duplicados, nos da igual el orden delos elementos.
// LIST : Pueden existir valores duplicados.
// MAP : Se accede rapido a la informacion.
//treeSet TreeMap : Se van ordenando cuando introducimos ( llama a conpareTo)


public class Main {

	public static void main(String[] args) {

		GestionUsuarios gu = new GestionUsuarios();
		
		//EJEMPLO SET
		HashSet<Alumno> alumnos = new HashSet<Alumno>();
		//-------------- Alumnos ------------
		Alumno alu1 = new Alumno("carlos", "iribarren");
		Alumno alu2 = new Alumno("David", "Izquierda");
		Alumno alu3 = new Alumno("Yosu", "derecha");
		
		//Introducimos 2 objetos con la misma referencia en memoria (alu1)
		// Como es un HashSet, solo va a introducir un objeto.
		alumnos.add(alu1);
		alumnos.add(alu1);
		alumnos.add(alu2);
		alumnos.add(alu3);
		System.out.println("------------------- ALUMNOS - HashSet ------------------");
		System.out.println("Imprimir todos los alunmos de un HashSet");
		for ( Alumno a : alumnos)
		{
			System.out.print("Nombre : " +a.getNombre());
			System.out.print(" - Apellido : " +a.getApellido() + "\n");
		}
		
		
		//------------- EJEMPLO LIST ------------------
		//-------------- Profesores ------------
		Profesor pro1 = new  Profesor("Juan", 30);
		Profesor pro2 = new  Profesor("Luis", 29);
		Profesor pro3 = new  Profesor("Pepe", 44);
		
		LinkedList<Profesor> profesores = gu.getProfesores();
		
		//En una List pueden existir objetos duplicados
		// añadimos dos objetos con las misma referencia (pro1)
		// El List admite objetos duplicados
		
		profesores.add(pro1);
		profesores.add(pro1);
		profesores.add(pro2);
		profesores.add(pro3);
		
		System.out.println("----------------- PROFESORES - LinkedList -------------------");
		System.out.println("Metodo toString de Clase Profesor : \n" + profesores.toString());
		System.out.println("\n Recorrer todo el linkedList - Listar todos los profesores");
		//definir un iterator para recorrer el linkedList
		
		for(Profesor pro : profesores )
		{
			System.out.print("Nombre : " + pro.getNombre() );
			System.out.print(" - Edad : " + pro.getEdad() + "\n");
			
		}
		
		//--------------- EJEMPLO MAP ------------------------ 
		// Se accede rapido a la informacion. Malo para ordenar y recorrer.	    
		System.out.println("----------- PERSONAS - Map ------------");
		
		//-------------- Personas ------------
		Persona pe1 = new Persona("Ana", "garcia");
		Persona pe2 = new Persona("Maria", "garcia");
		Persona pe3 = new Persona("Ahinoa", "etxebeste");
		
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		
		personas.put("clave1",pe1);
		personas.put("clave2",pe2);
		personas.put("clave3",pe3);
		
		//imprimir todos los objetos con el metodo toString de la clase Persona
		System.out.println("Metodo toString de la clase Persona");
		System.out.println(personas.toString());
		
		//buscar un objeto en concreto 
		boolean existe = personas.containsKey("clave1");
		System.out.println("Buscar el objeto por la clave, existe la clave1 : " + existe);
		
		//-------------------- EJEMPLO MAP ---------------------------------
		
		
		
		
		
		
	}

}
