/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.invocador;

import core.patrones.comando.Comando;


/**
 * Clase que es el INVOCADOR.
 *
 * @author ciribarren
 */
public class PanelFrontal {

  // ******************
  // *** ATRIBUTOS ***
  // ******************

  private Comando comando;

  // ************************
  // *** METODOS PUBLICOS ***
  // ************************

  /** Recibe un comando para parametro y lo asigna */
  public void asignarComnando(final Comando comando) {
    this.comando = comando;
  }

  /** Metodo para ejecutar el comando */
  public void palancaAccionada() {
    this.comando.ejecutar();
  }

}
