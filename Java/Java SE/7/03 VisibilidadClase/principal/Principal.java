package principal;

import pakete.CochePublico;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Instanciar objetos
		CochePublico miCocheFord = new CochePublico();
		
		miCocheFord.encender();
		
		System.out.println("Estado del coche despues de encender : \n" + miCocheFord.getMarca()
				+ " - " + miCocheFord.getModelo() + ": " + miCocheFord.getStado());
		
		miCocheFord.apagar();
		
		
		System.out.println("Estado del coche despues de apagar : \n" + miCocheFord.getMarca()
				+ " - " + miCocheFord.getModelo() + ": " + miCocheFord.getStado());
			
		
		System.out.println("\n" + miCocheFord.toString());
		
		
		
	}

}
