package net.izfe.g210.hgfzergabidea.modelos.modelo048.ejercicio2014.core.beans;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (value = Parameterized.class)
public class CalculadoraTest {

	//Atributo para parametrizar la clase que hace el test
	private Calculadora calculadoraParametrizada;

	//Atributo para parametrizar el resultado
	private Integer resultadoParametrizado;

	//Constructor para recibir los parametros
	public CalculadoraTest(Calculadora calculadora, Integer resultado) {
		this.calculadoraParametrizada = calculadora;
		this.resultadoParametrizado = resultado;
	}

	//Se definen algunos valores (Se utiliza el constructor para crear los valores)
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {  {new Calculadora(new Integer(0), new Integer(0)), 		new Integer(0) },
											{new Calculadora(new Integer(1), new Integer(356)), 	new Integer(357) },
											{new Calculadora(new Integer(-65468), new Integer(0)), 	new Integer(-65468) },
											{new Calculadora(new Integer(-68), new Integer(869)), 	new Integer(801) },
											{new Calculadora(new Integer(12), new Integer(12)), 	new Integer(24) } };
			return Arrays.asList(data);
	}


	/**
	 * Test para probar el metodo "public Integer calcularSuma()". 
	 */
	@Test
	public void testCalcularSuma()
	{
		//Recibir los paramteros
		Calculadora calculadoraTest = calculadoraParametrizada;
		Integer resultadoEsperado = resultadoParametrizado;
		//Probar el metodo
		Assert.assertTrue(resultadoEsperado.equals(calculadoraTest.calcularSuma()));

	}

}
