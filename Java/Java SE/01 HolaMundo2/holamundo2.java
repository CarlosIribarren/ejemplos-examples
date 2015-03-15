package holaMundo2;

public class holamundo2 {
	public static void main (String args[]) {
		System.out.println("Número de argumentos: "+args.length);
		if (args.length > 0)
			System.out.println("Hola "+args[0]);
		else
			System.out.println("Para añadir un parámetro ejecuta: java holamundo2 PARAMETRO1 PARAMETRO2");
	}
}