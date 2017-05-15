/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.bicicleta;

/**
 * @author ciribarren
 */
public class Velocimetro {

  // ******************
  // *** ATRIBUTOS ***
  // ******************

  private Integer velocidad;

  public Velocimetro() {
    this.velocidad = 5;
  }

  /**
   * Obtiene el campo de velocidad
   * 
   * @return the velocidad
   */
  public Integer getVelocidad() {
    return this.velocidad;
  }

  /**
   * Establece el campo velocidad
   *
   * @param velocidad Nuevo valor del campo velocidad
   */
  public void setVelocidad(final Integer velocidad) {
    this.velocidad = velocidad;
  }

}
