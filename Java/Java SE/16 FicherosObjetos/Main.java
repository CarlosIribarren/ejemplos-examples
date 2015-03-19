import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//crear objeto persona
		Persona p = new Persona("carlos", "iribarren");
		Persona pRecibida=null;

		//------------ CREAR --------------------------
		//crear flujo de salida hacia el fichero
		FileOutputStream fos = new FileOutputStream("archivo.txt");
		//crear un Stream de salida, apuntando al fichero
		ObjectOutputStream ous = new ObjectOutputStream(fos);
		//escribir el objeto serializado en el fichero
		ous.writeObject(p);
		//cerrar el flujo
		ous.close();
		
		
		//--------------- LEER --------------------------
		//leer fichero
		//definir un flujo de entrada en archivo.txt
		FileInputStream fis = new FileInputStream("archivo.txt");
		//crear un flujo de entrada de objetos, apuntando al fichero
		ObjectInputStream ois = new ObjectInputStream(fis);
		//leer el objeto
		pRecibida = (Persona) ois.readObject();
		//cerrar el flujo
		ois.close();
		
		//mostrar los resultados
		System.out.println("Resultado de la lectura de archivo.txt");
		System.out.println("Nombre :" + pRecibida.getNombre());
		System.out.println("Apellido :" + pRecibida.getApellido());
		
		
	}

}
