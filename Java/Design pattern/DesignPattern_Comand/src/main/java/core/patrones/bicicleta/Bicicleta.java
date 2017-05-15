/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.bicicleta;

/**
 * La clase Bicicleta es el RECEPTOR.
 *
 * @author ciribarren
 */
public class Bicicleta {

  private Engranaje engranaje;
  private Velocimetro velocimetro;

  public Bicicleta() {
    this.engranaje = new Engranaje();
    this.velocimetro = new Velocimetro();
  }

  /**
   * Obtiene el campo de engranaje
   *
   * @return the engranaje
   */
  public Engranaje getEngranaje() {
    return this.engranaje;
  }

  /**
   * Establece el campo engranaje
   *
   * @param engranaje Nuevo valor del campo engranaje
   */
  public void setEngranaje(final Engranaje engranaje) {
    this.engranaje = engranaje;
  }

  /**
   * Obtiene el campo de velocimetro
   *
   * @return the velocimetro
   */
  public Velocimetro getVelocimetro() {
    return this.velocimetro;
  }

  /**
   * Establece el campo velocimetro
   *
   * @param velocimetro Nuevo valor del campo velocimetro
   */
  public void setVelocimetro(final Velocimetro velocimetro) {
    this.velocimetro = velocimetro;
  }

}
