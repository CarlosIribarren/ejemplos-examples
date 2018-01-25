/*
 * Copyright (c) 2016, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
*/
package net.izfe.g210.hgfzergabideariquezaweb.modelos.modelo714.ejercicio2017.web.utils;

import java.util.Date;

import net.izfe.g210.hgfzergabideacomuncorelib.core.beans.Importe;

import org.springframework.stereotype.Component;


/**
 * Funciones de formateo de textos para su visualizacion
 *
 * @author IZFE S.A.
 * @version 1.0
 */
@Component("entradaSalidaRiqueza7142017")
public final class EntradaSalida {

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  /** Constructor sin valores */
  private EntradaSalida() {
  }

  // *******************
  // ***** METODOS *****
  // *******************

  public static final boolean esVacio(final Object campo) {

    boolean vacio = false;

    if (campo == null) {
      vacio = true;

    } else if (campo instanceof String) {

      // String
      final String string = (String) campo;
      if (string.trim().length() == 0) {
        vacio = true;
      }
      if (string.isEmpty()) {
        vacio = true;
      }

      // Importe
    } else if (campo instanceof Importe) {
      final Importe importe = (Importe) campo;
      if (importe.igualACero()) {
        vacio = true;
      }

      // Integer
    } else if (campo instanceof Integer) {
      final Integer integer = (Integer) campo;
      if (integer == 0) {
        vacio = true;
      }

      // Double
    } else if (campo instanceof Double) {
      final Double doble = (Double) campo;
      if (doble == 0) {
        vacio = true;
      }

      // Date
    } else if (campo instanceof Date) {
      final Date d = (Date) campo;
      try {
        d.getTime();
      } catch (final RuntimeException e) {
        vacio = true;
      }

    }

    return vacio;
  }

}
