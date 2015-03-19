import java.util.LinkedList;

// info del ejemplo :
// en este ejemplo se muestra como cuando en una clase definimos los metodos
// de equals y de hashcode, cuando compara o busca utiliza los metodos que hemos 
// definido para conpararlos. La clase Persona tiene ( hashcode y equals ) y 
// la clase Coche tiene ( hashcode y equals ). si no implementamos los metodos de las 
// dos clases, entonces la comparacion no funcionara


public class Main {

	public static void main(String[] args) {

		Coche c1 = new Coche("peugeot", 90);
		Coche c2 = new Coche("peugeot", 90);
		
		Persona p1 = new Persona("Carlos",c1);
		Persona p2 = new Persona("Juan",c2);
		//p3 es un objeto con refencia distinta de p2, pero
		//tiene los mismos atributos, y como hemos implementado los metodos
		// equals y hascode, ahora compara los atributos
		Persona p3 = new Persona("Juan",c2);
		
		//definir una lista
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		
		boolean existe = listaPersonas.contains(p3);
		System.out.println("Existe p3 en la lista :\n" + existe );
		
		boolean iguales = p1.equals(p2);
		System.out.println("Equals de p1 con p2 : \n" + iguales );
		
	}

}
