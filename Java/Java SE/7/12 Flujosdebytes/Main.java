import java.io.BufferedInputStream;
import java.io.IOException;

// ejemplo de flujo de bytes
// en este ejemplo se muestra como leer del teclado
// caracter a caracter. No acaba nunca, porque 
// cuando esta leyendo no sabe cuando hemos terminado de leer.


public class Main {

	public static void main(String[] args) {
		
		BufferedInputStream bufer = new BufferedInputStream(System.in);
		Boolean terminado=false;
		int dataByte=0;
		char c;
		String erantzuna="";
		while (terminado==false)
		{
			try {
				
				dataByte = bufer.read();
				c = (char) dataByte;
				erantzuna = erantzuna + c;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (dataByte==-1)
			{
				terminado=true;
			}
		}
		System.out.println(erantzuna);
		
		
	}

}
