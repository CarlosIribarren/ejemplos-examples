import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) {

		System.out.println("Escribe una linea : ");
		String linea = "linea";
		
		//-------------------- ENTRADA ---------------------
		//Definir la entrada
		InputStream input = System.in;
		//leer el Stream que hemos recibido
		InputStreamReader isr = new InputStreamReader(input);
		//Utilizamos un lector de buffer, para leer con mas comodidad 
		BufferedReader br = new BufferedReader(isr);
		//Leer el STREAM de entrada
		try {
			linea = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// ---------- SALIDA ----------------------------------
		//Definir la Salida
		OutputStream out = System.out;
		//definimos un writer de STREAM
		OutputStreamWriter osw = new OutputStreamWriter(out );
		//utilizamos un writer de buffers, que nos ayuda a escribir.
		BufferedWriter bw = new BufferedWriter(osw);
		//Escribir el STREAM de salida
		try {
			bw.write(linea);
			// Forzamos a que escriba la salida
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
