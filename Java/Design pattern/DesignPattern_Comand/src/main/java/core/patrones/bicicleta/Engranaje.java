/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.bicicleta;

/**
 * @author ciribarren
 */
public class Engranaje {

  // ******************
  // *** ATRIBUTOS ***
  // ******************

  private String estado;

  // ******************
  // *** CONSTRUCTOR **
  // ******************

  public Engranaje() {
    super();
    this.estado = "Desconfigurado";
  }

  // ************************
  // *** METODOS PUBLICOS ***
  // ************************

  public void mayorVelocidad() {
    this.estado = "Encaminado a tener mayor velocidad";
  }

  public void menorVelocidad() {
    this.estado = "Encaminado a tener menor velocidad";
  }

  // *******************
  // * GETTER Y SETTER *
  // *******************

  /**
   * Obtiene el campo de estado
   *
   * @return the estado
   */
  public String getEstado() {
    return this.estado;
  }

  /**
   * Establece el campo estado
   *
   * @param estado Nuevo valor del campo estado
   */
  public void setEstado(final String estado) {
    this.estado = estado;
  }

}
