import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Añadir una clase que contenga un atributo nombre de tipo String y un array de amigos que puedan añadirse. Al terminar de añadir amigos mostrar el listado.
 */


public class Main {

	private enum semana { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
	
	public static void main(String[] args) {

		System.out.println("\n***** AÑADIR AMIGOS *****\n");

		//definir un canal de entrada de datos
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		
		//leer del teclado el nombre
		String nombre="";
		System.out.print("\tEscribe tu nombre : ");
		try {
			nombre = lectura.readLine();
		} catch (IOException e) {
			System.out.println(" ¡Error de lectura! ");
		}
		//leer del teclado cuantos amigos quiere añadir
		String numeroAmigosString="";
		Integer numeroAmigos=0;
		System.out.print("\tEscribe el numero de amigos que quieres añadir : ");
		try {
			numeroAmigosString = lectura.readLine();
			numeroAmigos = new Integer(numeroAmigosString);
			
		} catch (IOException e) {
			System.out.println(" ¡Error de lectura! ");
		
		}catch (NumberFormatException e) {
			System.out.println(" ¡No es un numero! ");
		}
		//crear la persona con el numero de amigos que quiere
		Persona p = new Persona(numeroAmigos);
		//añadir el nombre de la persona
		p.setNombre(nombre);		
		//saludar a usuario
		System.out.println("\tHola : "+nombre);
		System.out.println("\tSi quieres detener de introducir amigos, escribir el nombre de amigo 'terminar' ");
		
		String amigo="";
		Integer cont=0;
		while ("terminar".compareTo(amigo)!=0 && cont<numeroAmigos)
		{
			System.out.print("\tEscribe el nombre del amigo " + (cont+1) +" : " );
			try {
				amigo = lectura.readLine();
			} catch (IOException e) {
				System.out.println(" ¡Error de lectura! ");
			}
			
			if (amigo.equals("terminar"))
			{
				System.out.println("\tAmigos guardados con exito!!!!!");
			}
			else
			{
				p.añadirAmigo(amigo);
				System.out.println("\tAmigo guardado : "+amigo);
			}
			cont=cont+1;
		}
		System.out.println("\tResultado : " + p.toString());


	}

}
