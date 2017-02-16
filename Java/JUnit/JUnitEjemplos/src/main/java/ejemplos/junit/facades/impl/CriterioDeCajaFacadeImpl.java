
package ejemplos.junit.facades.impl;

import ejemplos.junit.bean.CriterioDeCaja;
import ejemplos.junit.facades.CriterioDeCajaFacade;


public class CriterioDeCajaFacadeImpl implements CriterioDeCajaFacade {

  public void asignarValoresSinActividad(final CriterioDeCaja criterioDeCaja) {

    if (criterioDeCaja == null) {

      throw new NullPointerException();

    } else {

      criterioDeCaja.setEntregasBase(new Double(0));
      criterioDeCaja.setEntregasCuota(new Double(0));

      criterioDeCaja.setAdquisicionesBase(new Double(0));
      criterioDeCaja.setAdquisicionesCuota(new Double(0));
    }

  }

}
