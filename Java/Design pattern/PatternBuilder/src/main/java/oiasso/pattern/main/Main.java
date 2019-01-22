package oiasso.pattern.main;

import oiasso.pattern.beans.Persona;
import oiasso.pattern.builders.PersonaBuilder;

public class Main {

	public static void main(String[] args) {

		Persona p = new PersonaBuilder().nombre("Nombre 1")
										.apellidos("Apellidos 1")
										.direccion("Direccion 1")
										.email("email 1")
										.build();

		System.out.println(p.toString());
	}

}
