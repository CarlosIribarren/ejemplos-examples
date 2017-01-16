import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person implements Serializable {

  // *****************
  // *** CONSTANTES **
  // *****************

  private static final long serialVersionUID = -7332294325275735197L;

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  /** Datos generales */
  private DatosGenerales datosGenerales;

  /** Iva devengado */
  private IvaDevengado ivaDevengado;


  // ***********************
  // *** METODOS GET/SET **
  // ***********************

  /**
   * @return the datosGenerales
   */
  public final DatosGenerales getDatosGenerales() {
    return this.datosGenerales;
  }

  /**
   * @param datosGenerales the datosGenerales to set
   */
  public final void setDatosGenerales(final DatosGenerales datosGenerales) {
    this.datosGenerales = datosGenerales;
  }

  /**
   * @return the ivaDevengado
   */
  public final IvaDevengado getIvaDevengado() {
    return this.ivaDevengado;
  }

  /**
   * @param ivaDevengado the ivaDevengado to set
   */
  public final void setIvaDevengado(final IvaDevengado ivaDevengado) {
    this.ivaDevengado = ivaDevengado;
  }

  // **************************
  // ***** MÉTODOS EQUALS *****
  // **************************

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }

    if ((obj == null) || !(obj instanceof Person)) {
      return false;
    }

    final Person other = (Person) obj;

    EqualsBuilder eBuilder = new EqualsBuilder();

    eBuilder = eBuilder.append(this.datosGenerales, other.datosGenerales);
    eBuilder = eBuilder.append(this.ivaDevengado, other.ivaDevengado);

    return eBuilder.isEquals();
  }

  @Override
  public int hashCode() {

    final HashCodeBuilder hcBuilder = new HashCodeBuilder(17, 31);

    hcBuilder.append(this.datosGenerales);
    hcBuilder.append(this.ivaDevengado);

    return hcBuilder.toHashCode();
  }
}
