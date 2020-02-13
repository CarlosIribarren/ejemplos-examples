


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circulo c1 = new Circulo("Circulo 1",1.1f);
		Circulo c2 = new Circulo("Circulo 2",2.2f);
		
		Rectangulo r1 = new Rectangulo("Rectangulo 1",3.3f,4.4f);
		Rectangulo r2 = new Rectangulo("Rectangulo 2",5.5f,6.6f);
		

		Figura listaFiguras[] = new Figura[4];
		
		listaFiguras[0]=c1;
		listaFiguras[1]=c2;
		listaFiguras[2]=r1;
		listaFiguras[3]=r2;
		
		for (Figura figura : listaFiguras) {
			System.out.print(figura.toString());
			
			Float area = figura.calcularArea();
			System.out.println( "el area es : " +area);
		}
		
		
	}

}
