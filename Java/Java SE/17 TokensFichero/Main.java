import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;


public class Main {

	public static void main(String[] args){
		
		//----- crear archivo de txt ------------------------
		
		FileReader fr = null;
		try {
			fr = new FileReader("texto.txt");
		} catch (FileNotFoundException e) {
			System.out.println("el fichero no existe");
		}
		
		//crear un lector de buffers 
		BufferedReader br = new BufferedReader(fr);
		
		StreamTokenizer st = new StreamTokenizer(br);
		
		int tipoTokenizer = 0, contadorPalabras = 0, contadorNumeros = 0, contadorLineas=0;
		boolean salir = false;
		do{
			try {
				tipoTokenizer = st.nextToken();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (tipoTokenizer) {
				case StreamTokenizer.TT_EOF:
					salir=true;
					break;
				case StreamTokenizer.TT_EOL:
					contadorLineas = contadorLineas+1;
					break;
				case StreamTokenizer.TT_NUMBER:
					contadorNumeros=contadorNumeros+1;
					break;
				case StreamTokenizer.TT_WORD:
					contadorPalabras=contadorPalabras+1;
					break;
				default:
					break;
			}
		}
		while(salir==false);
		
		System.out.println("lineas : " + contadorLineas);
		System.out.println("palabras : " + contadorPalabras);
		System.out.println("numeros : " + contadorNumeros);
		
		Integer total ;
		total = contadorLineas + contadorNumeros + contadorPalabras;
		
		
		System.out.println("numero de tokens total:" + total);
	}

}
