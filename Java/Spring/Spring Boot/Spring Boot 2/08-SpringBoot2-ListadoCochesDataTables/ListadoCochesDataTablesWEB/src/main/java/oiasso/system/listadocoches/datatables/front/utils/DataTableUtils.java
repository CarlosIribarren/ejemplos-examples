package oiasso.system.listadocoches.datatables.front.utils;

public class DataTableUtils {

	private DataTableUtils() {
		throw new IllegalStateException("DataTableUtils have non-public constructor.");
	}

	/**
	 * Calcula el numero de pagina, dado el primer elemento de la pagina y los
	 * elementos por pagina.
	 * 
	 * @param primerElementoDeLaPagina Primer elemento de la pagina
	 * @param elementosPorPagina       Elementos por pagina
	 * @return Retorna el numero de pagina.
	 */
	public static Integer calcularNumeroDePagina(Integer primerElementoDeLaPagina, Integer elementosPorPagina) {

		// Calcular numero de pagina
		if (elementosPorPagina.equals(0)) {
			elementosPorPagina = 1;
		}
		return (int) Math.ceil((double) primerElementoDeLaPagina / elementosPorPagina);
	}

}
