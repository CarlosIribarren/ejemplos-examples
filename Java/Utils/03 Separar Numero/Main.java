public class Main {

	public static void main(String[] args) {

		//Separa un numero de 4 digitos fijos.
		//Ejercicio (numero0,numero1,numero2,numero3)
		int ejercicio = 2014;
		String ejercicioString = Integer.toString(ejercicio);
		char[] ejercicioArray = ejercicioString.toCharArray();
		
		char ejercicio0 = ejercicioArray[0];
		char ejercicio1 = ejercicioArray[1];
		char ejercicio2 = ejercicioArray[2];
		char ejercicio3 = ejercicioArray[3];
		
		System.out.println("************** EJERCICIO: "+ ejercicio );
		System.out.println("TBox_EJERCICIO_1:"+ ejercicio0 );
		System.out.println("TBox_EJERCICIO_2:"+ ejercicio1 );
		System.out.println("TBox_EJERCICIO_3:"+ ejercicio2 );
		System.out.println("TBox_EJERCICIO_4:"+ ejercicio3 );
		System.out.println("*** EJERCICIO: "+ ejercicio0 + ejercicio1+ ejercicio2+ ejercicio3  );
		System.out.println("****************************************************");
		
		//Separa un numero de 2 digitos. Si es un solo digito, se introcude un cero delante.
		//Periodo (periodo0,periodo1)
		int periodo = 2;

		String periodoString = Integer.toString(periodo);
		char[] periodoArray = periodoString.toCharArray();
		char p0;
		char p1;
		
		if(periodo>9)
		{
			p0 = periodoArray[0];
			p1 = periodoArray[1];
		}
		else
		{
			p0 = '0';
			p1 = periodoArray[0];
		}
		
		System.out.println("************* PERIODO CORTO: "+ periodo );
		System.out.println("TBox_PERIODO_CORTO_1: " + p0 );
		System.out.println("TBox_PERIODO_CORTO_2: " + p1 );
		System.out.println("*** PERIODO CORTO: "+ p0 + p1 );

	}

}
