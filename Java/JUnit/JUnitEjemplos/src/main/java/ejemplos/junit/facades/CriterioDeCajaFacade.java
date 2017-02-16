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

}
