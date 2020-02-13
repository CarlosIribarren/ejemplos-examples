import java.util.Collections;
import java.util.LinkedList;


public class Main {
	
//ejemplo para mostrar como ordenar una lista como nosotros queramos
// este caso vamos a ordenar la lista por la potencia del motor ( ascendente )
// hay que implementar la interface conparable en la clase Coche
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coche c1 = new Coche("Peugeot", 90);
		Coche c2 = new Coche("Ford1", 115);
		Coche c3 = new Coche("Ford2", 85);
		
		LinkedList<Coche> listaCoches = new LinkedList<Coche>();
		
		listaCoches.add(c1);
		listaCoches.add(c2);
		listaCoches.add(c3);
		
		System.out.println("------- mostrar los resultados sin ordenar: ---------------- ");
		for ( Coche c : listaCoches)
		{
			System.out.print("Nombre : " + c.getNombre());
			System.out.print(" / Potencia : " + c.getPotencia() + "\n");
		}
		
		//ordenar
		Collections.sort(listaCoches);
		
		System.out.println("-------- mostrar los resultados ordenados ascendente -----------: ");
		for ( Coche c : listaCoches)
		{
			System.out.print("Nombre : " + c.getNombre());
			System.out.print(" / Potencia : " + c.getPotencia() + "\n");
		}
		
		// Ordenar descendente
		// En este caso utilizamos la clase (CocheComparator) que implementa la interface
		// Comparator, implementaremos el metodo compare para definir como queremos que 
		// conpare los Coches.
		// en este caso se pasa el conparador como clase.
		Collections.sort(listaCoches, new CocheComparator());
		
		System.out.println("----------- mostrar los resultados ordenados descendente: -------------- ");
		for ( Coche c : listaCoches)
		{
			System.out.print("Nombre : " + c.getNombre());
			System.out.print(" / Potencia : " + c.getPotencia() + "\n");
		}
		
		
		
	}

}
