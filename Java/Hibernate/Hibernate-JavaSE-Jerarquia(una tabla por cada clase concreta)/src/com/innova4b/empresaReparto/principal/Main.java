package com.innova4b.empresaReparto.principal;

import org.hibernate.cfg.Configuration;

import org.hibernate.cfg.Environment;

public class Main {

	public static void main(String[] args) {

		//----------- METODO 1 : CARGAR LA CONFIGURACION A MANO ----------------
		//definimos un objeto de configuracion de Hibernate
		//Luego cargamos en ese objeto de configuracion a mano
		Configuration cfg = new Configuration();
		
		//cargar propiedad a mano
		cfg.setProperty("hibernate.connection.username", "root");
		//cargar un mapeo ( objetos - relacional ) a mano MODO1
			//cfg.addResource("com/innova4b/empresaReparto/persistent/Empleado.hbm.xml");
		//cargar un mapeo ( objetos - relacional ) a mano MODO2
		//cfg.addClass(com.innova4b.empresaReparto.persistent.Empleado.class);
		//---------- fin metodo 1 -----------------------------------
		
		
		
		
		// ---------------- metodo 2 --------------------------------
		//este metodo carga el fichero hibernate.cfg.xml con las 
		// propiedades que estan descritas hay. Cuando hace eso 
		// machaka las propiedades descritas en el fichero hibernate.properties
		
		Configuration cfg2 = new Configuration().configure();
		
		//-------------------------------------
		
	}

}
