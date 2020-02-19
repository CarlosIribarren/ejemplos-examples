package oiasso.system.examples.jpa.datatables.utils;

public class DataTableUtils {

	public static Integer calcularNumeroDePagina(Integer primerElementoDeLaPagina, Integer elementosPorPagina) {

		// Calcular numero de pagina
		if (elementosPorPagina.equals(0)) {
			elementosPorPagina = 1;
		}
		return new Double(Math.ceil(primerElementoDeLaPagina / elementosPorPagina)).intValue();
	}

}
