import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// LEER DEL TECLADO
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		String dato="";
		System.out.println("Escribe tu nombre : ");
		try {
			
			dato = lectura.readLine();
			if (dato.isEmpty())
			{
				//lanzar la excepcion
				//creando una excepcion de tipo x
				throw new ExcepcionCadenaVacia();
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		//tratar la excepcion que hemos lanzado
		} catch (ExcepcionCadenaVacia e) {
			System.out.println(e.getMessage());
		}

	}

}
