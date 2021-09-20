package oiasso.systems.examples.java8.p02_lambda.ejemplo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjemploLambda2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploLambda2.class);

	public static void main(String[] args) {

		EjemploLambda2 ejemploLambda2 = new EjemploLambda2();
		ejemploLambda2.calcularJava7();
		ejemploLambda2.calcularJava8();

	}

	public void calcularJava7(){

		// ************** JAVA 7 *************************
		Operacion operacion = new Operacion(){

			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1 + n2) / 2;
			}
			
		};

		LOGGER.info("Java 7 Calcular promedio : {}", operacion.calcularPromedio(2, 3) );

	}


	public void calcularJava8(){


		// ************** JAVA 8 *************************
		// Expresion Lambda:
		// (parametros) -> expresion

		// Se pasa un implementacion de la interface con la expresion lambda
		Operacion operacion = (double x, double y) -> (x+y)/2;

		LOGGER.info("Java 8 Calcular promedio : {}", operacion.calcularPromedio(3, 3) );
		



		

	}

}
