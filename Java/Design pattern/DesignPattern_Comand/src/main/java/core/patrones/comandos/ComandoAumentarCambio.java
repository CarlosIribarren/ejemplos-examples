/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.comandos;

import core.patrones.bicicleta.Bicicleta;
import core.patrones.comando.Comando;
import core.patrones.utils.Impresor;


/**
 * Uno de los comandos concretos. Tiene una bicicleta y tiene un visor para visualizar la velocidad de la bicicleta.
 * Este comando sirve para que el engranaje permita mayor velocidad de la bicicleta.
 *
 * @author ciribarren
 */
public class ComandoAumentarCambio implements Comando {

  // ******************
  // *** ATRIBUTOS ***
  // ******************

  private final Bicicleta miBici;

  /** Sirve para visualizar la velocidad de la bicicleta */
  private final Impresor visor;

  // ************************
  // *** METODOS PUBLICOS ***
  // ************************

  public ComandoAumentarCambio() {
    this.miBici = new Bicicleta();
    this.visor = new Impresor();
  }

  public void ejecutar() {
    this.miBici.getEngranaje().mayorVelocidad();
    this.miBici.getVelocimetro().setVelocidad(40);

    this.visor.imprimir(this.miBici.getEngranaje().getEstado());
    this.visor.imprimir("La velocidad maxima es : " + this.miBici.getVelocimetro().getVelocidad().toString() + "Km/h");

  }

}
