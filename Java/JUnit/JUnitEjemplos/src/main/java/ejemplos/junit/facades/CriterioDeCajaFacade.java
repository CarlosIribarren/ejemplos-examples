package ejemplos.junit.facades;

import ejemplos.junit.bean.CriterioDeCaja;


public interface CriterioDeCajaFacade {

  /**
   * Asigna los valores correspondientes para una declaracion sin actividad en la clase CriterioDeCaja.
   * Asigna el valor 0 en todos los atributos de la clase CriterioDeCaja.
   *
   * @param criterioDeCaja Criterio De Caja
   */
  void asignarValoresSinActividad(CriterioDeCaja criterioDeCaja);

  /**
   * Obtiene un Criterio de Caja dado un id de la BD y le suma 1 en todos sus valores.
   *
   * @param id Identificador
   * @return Retorna el Criterio de Caja
   */
  CriterioDeCaja obtenerYSumar1(int id);

}
