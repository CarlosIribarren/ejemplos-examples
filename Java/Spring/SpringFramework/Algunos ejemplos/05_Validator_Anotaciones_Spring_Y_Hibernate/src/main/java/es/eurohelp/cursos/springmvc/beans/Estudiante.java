package es.eurohelp.cursos.springmvc.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


/*
 * NotEmpty to Integer is not a valid type for it to check. It's for Strings and collections.
 * If you just want to make sure an Integer has some value, javax.validation.constraints.NotNull
 * is all you need.
 */

public class Estudiante {

  private Integer id;

  @NotEmpty // Nombre no puede ser vacio
  private String nombre;

  @NotNull // Edad no puede ser null/vacio
  @Range(min = 1, max = 150) // Edad entre 1 y 150
  private Integer edad;

  // Cuando se quiere validar en las sub-clases.
  @Valid
  private Resultado resultado;

  public Estudiante() {
    this.resultado = new Resultado();
  }

  public Resultado getResultado() {
    return this.resultado;
  }

  public void setResultado(final Resultado resultado) {
    this.resultado = resultado;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }

  public Integer getEdad() {
    return this.edad;
  }

  public void setEdad(final Integer edad) {
    this.edad = edad;
  }

}
