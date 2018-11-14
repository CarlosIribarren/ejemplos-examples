package ejemplos.junit.bean;

public class Usuario {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  private Integer codigo;

  private String nombre;

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  public Usuario() {
  }

  // *************************
  // *** METODOS GET Y SET ***
  // *************************

  /**
   * @return the codigo
   */
  public final Integer getCodigo() {
    return this.codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public final void setCodigo(final Integer codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the nombre
   */
  public final String getNombre() {
    return this.nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public final void setNombre(final String nombre) {
    this.nombre = nombre;
  }

}
