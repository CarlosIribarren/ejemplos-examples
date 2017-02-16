
package ejemplos.junit.facades.impl;

import ejemplos.junit.bean.CriterioDeCaja;
import ejemplos.junit.daos.CriterioDeCajaDao;
import ejemplos.junit.daos.impl.CriterioDeCajaDaoImpl;
import ejemplos.junit.facades.CriterioDeCajaFacade;


public class CriterioDeCajaFacadeImpl implements CriterioDeCajaFacade {

  private final CriterioDeCajaDao criterioDeCajaDao = new CriterioDeCajaDaoImpl();

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

  public CriterioDeCaja obtenerYSumar1(final int id) {

    final CriterioDeCaja criterioDeCaja = this.criterioDeCajaDao.getCriterioDeCaja(id);

    Double adquisicionesBase = criterioDeCaja.getAdquisicionesBase();
    Double adquisicionesCuota = criterioDeCaja.getAdquisicionesCuota();
    Double entregasBase = criterioDeCaja.getEntregasBase();
    Double entregasCuota = criterioDeCaja.getEntregasCuota();

    adquisicionesBase = adquisicionesBase + 1;
    adquisicionesCuota = adquisicionesCuota + 1;
    entregasBase = entregasBase + 1;
    entregasCuota = entregasCuota + 1;

    criterioDeCaja.setAdquisicionesBase(adquisicionesBase);
    criterioDeCaja.setAdquisicionesCuota(adquisicionesCuota);
    criterioDeCaja.setEntregasBase(entregasBase);
    criterioDeCaja.setEntregasCuota(entregasCuota);

    return criterioDeCaja;
  }

}
