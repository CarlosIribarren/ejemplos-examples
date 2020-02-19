import java.io.IOException;
import java.io.ObjectOutputStream;


public class Main {

	public static void main(String[] args) {

		//crear objeto serializable
		Persona p = new Persona("nombre","apeliido");
		
		ObjectOutputStream ous = null;
		try {
			ous = new ObjectOutputStream(System.out);
			ous.writeObject(p);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		
		
	}

}
