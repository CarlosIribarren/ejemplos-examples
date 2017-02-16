/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package ejemplos.junit.daos.impl;

import ejemplos.junit.bean.CriterioDeCaja;
import ejemplos.junit.daos.CriterioDeCajaDao;


/**
 * @author EuroHelp S.L.
 */
public class CriterioDeCajaDaoImpl implements CriterioDeCajaDao {

  public CriterioDeCajaDaoImpl() {
  }

  public CriterioDeCaja getCriterioDeCaja(final int id) {

    if (id == 1) {
      final CriterioDeCaja c1 = new CriterioDeCaja();
      c1.setAdquisicionesBase(new Double(1));
      c1.setAdquisicionesCuota(new Double(1));
      c1.setEntregasBase(new Double(1));
      c1.setEntregasCuota(new Double(1));
      return c1;
    }

    if (id == 2) {
      final CriterioDeCaja c2 = new CriterioDeCaja();
      c2.setAdquisicionesBase(new Double(1));
      c2.setAdquisicionesCuota(new Double(1));
      c2.setEntregasBase(new Double(1));
      c2.setEntregasCuota(new Double(1));
      return c2;
    }

    return null;
  }

}
