package oiasso.system.examples.jpa.datatables.front.utils;

public class DataTableUtils {

	private DataTableUtils() {
		throw new IllegalStateException("DataTableUtils have non-public constructor.");
	}

	public static Integer calcularNumeroDePagina(Integer primerElementoDeLaPagina, Integer elementosPorPagina) {

		// Calcular numero de pagina
		if (elementosPorPagina.equals(0)) {
			elementosPorPagina = 1;
		}
		return (int) Math.ceil((double) primerElementoDeLaPagina / elementosPorPagina);
	}

}
