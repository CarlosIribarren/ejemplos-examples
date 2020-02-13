package oiasso.system.listadocoches.datatables.front.utils;

import org.junit.Assert;
import org.junit.Test;

import oiasso.system.listadocoches.datatables.front.utils.DataTableUtils;


public class DataTableUtilsTest {

	/********************************************************
	 ** Integer calcularNumeroDePagina(Integer, Integer)
	 ********************************************************/

	@Test
	public void calcularNumeroDePagina_primerElementoDeLaPagina_0() {
		Integer resultado = DataTableUtils.calcularNumeroDePagina(1, 0);
		Assert.assertEquals(new Integer(1), resultado);
	}

	@Test
	public void calcularNumeroDePagina_elementosPorPagina_0() {
		Integer resultado = DataTableUtils.calcularNumeroDePagina(0, 1);
		Assert.assertEquals(new Integer(0), resultado);
	}

	@Test
	public void calcularNumeroDePagina_primerElementoDeLaPagina_22_elementosPorPagina_10() {
		Integer resultado = DataTableUtils.calcularNumeroDePagina(22, 10);
		Assert.assertEquals(new Integer(3), resultado);
	}

}
