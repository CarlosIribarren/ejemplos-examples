package oiasso.systems.examples.java8.p02_lambda.ejemplo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjemploLambda1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploLambda1.class);

	public static void main(String[] args) {

		EjemploLambda1 ejemploLambda1 = new EjemploLambda1();
		ejemploLambda1.ordenar();

	}

	public void ordenar(){

		List<String> listado = new ArrayList<>();
		listado.add("b");
		listado.add("a");
		listado.add("c");



		// ************** JAVA 7 *************************
		Collections.sort(listado, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});


		// ************** JAVA 8 *************************
		// Expresion Lambda:
		// (parametros) -> expresion
		Collections.sort(listado, (String p1, String p2) -> p1.compareTo(p2));




		for(String elemento : listado){
			LOGGER.info("elemento: {}",elemento);
		}

	}

}
