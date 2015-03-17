import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ACTIVIDAD 1
----------------------
Crear una clase que contenga un array de 10 enteros
Crear una clase ejecutable que copie los valores del array en orden inverso en un nuevo array
Añadir a la clase un tipo Enum con los días de la semana y mostrar distintos mensajes con la sentencia switch
Crear un objeto String con un texto largo que contenga las palabras 'begin' y 'end' y obtener un nuevo objeto String que contenga todo el texto contenido entre estas palabras
Añadir una clase que contenga un atributo nombre de tipo String y un array de amigos que puedan añadirse. Al terminar de añadir amigos mostrar el listado.
(¿Cómo leer del teclado?)
 */


public class Main {

	private enum semana { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
	
	public static void main(String[] args) {

		//------------ Example 1 -----------------------
		System.out.println("***** ORDEN INVERSO *****\n");
		Integer data[] ={1,2,3,4,5,6,7,8,9,10};
		System.out.print("\tInicio : ");
		for (int a=0; a<data.length;a++)
		{
			System.out.print(data[a] + " ");
		}	
		
		Integer inverso[]=new Integer[10];
		for (int counterA = data.length-1, contadorInverso=0; counterA >= 0;contadorInverso++, counterA--) {
			inverso[contadorInverso]=data[counterA];
		}
		System.out.print("\n\tResultado : ");
		for (int a=0; a<inverso.length;a++)
		{
			System.out.print(inverso[a]+ " ");
		}
		
		//------------ Example 2 -----------------------
		System.out.println("\n\n***** ENUM *****\n");
		System.out.println("\tIncio : Dia de la semana lunes");
		semana diaUsuario1;
		diaUsuario1 = semana.LUNES;
		switch (diaUsuario1.toString()) {
		case "LUNES":
			System.out.println("\tResultado : El dia es lunes ");
			break;
		case "MARTES":
			System.out.println("\tResultado : El dia es martes ");
			break;
		case "MIERCOLES":
			System.out.println("\tResultado : El dia es miercoles ");
			break;
		case "JUEVES":
			System.out.println("\tResultado : El dia es jueves ");
			break;
		case "VIERNES":
			System.out.println("\tResultado : El dia es viernes ");
			break;
		case "SABADO":
			System.out.println("\tResultado : El dia es sabado ");
			break;
		case "DOMINGO":
			System.out.println("\tResultado : El dia es domingo ");
			break;
		default:
			break;
		}
		//------------ Example 3 -----------------------
		System.out.println("\n***** PALABRAS BEGIN Y END *****\n");
		String string = "hello begind java enterprise edition end do";
		System.out.println("\tInicio : " + string);
		
		String result[] = string.split("begind");
		String result2[] = result[1].split("end");

		String resultTotal = result2[0];
		System.out.println("\tResultado : " + resultTotal);

		//------------ Example 4 -----------------------
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
