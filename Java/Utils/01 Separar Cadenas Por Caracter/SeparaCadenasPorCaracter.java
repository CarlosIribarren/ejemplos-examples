import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		String cadena,elemento;
		StringTokenizer elementos;
		cadena ="23;BAZAR;34";;
		elementos = new StringTokenizer(cadena,";");
		while(elementos.hasMoreTokens()){
		  elemento = elementos.nextToken();
		  System.out.println(elemento);
		}
	
		
	}
}
