package ejemplos.junit.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class CriterioDeCaja {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  /** Entregas - Criterio de Caja - Base */
  private Double entregasBase;

  /** Entregas - Criterio de Caja - Cuota */
  private Double entregasCuota;

  /** Adquisiciones - Criterio de Caja - Base */
  private Double adquisicionesBase;

  /** Adquisiciones - Criterio de Caja - Cuota */
  private Double adquisicionesCuota;

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  /** Constructor sin valores */
  public CriterioDeCaja() {
    //
  }

  // ***********************
  // *** MÉTODOS GET/SET ***
  // ***********************

  /**
   * @return the entregasBase
   */
  public final Double getEntregasBase() {
    return this.entregasBase;
  }

  /**
   * @param entregasBase the entregasBase to set
   */
  public final void setEntregasBase(final Double entregasBase) {
    this.entregasBase = entregasBase;
  }

  /**
   * @return the entregasCuota
   */
  public final Double getEntregasCuota() {
    return this.entregasCuota;
  }

  /**
   * @param entregasCuota the entregasCuota to set
   */
  public final void setEntregasCuota(final Double entregasCuota) {
    this.entregasCuota = entregasCuota;
  }

  /**
   * @return the adquisicionesBase
   */
  public final Double getAdquisicionesBase() {
    return this.adquisicionesBase;
  }

  /**
   * @param adquisicionesBase the adquisicionesBase to set
   */
  public final void setAdquisicionesBase(final Double adquisicionesBase) {
    this.adquisicionesBase = adquisicionesBase;
  }

  /**
   * @return the adquisicionesCuota
   */
  public final Double getAdquisicionesCuota() {
    return this.adquisicionesCuota;
  }

  /**
   * @param adquisicionesCuota the adquisicionesCuota to set
   */
  public final void setAdquisicionesCuota(final Double adquisicionesCuota) {
    this.adquisicionesCuota = adquisicionesCuota;
  }

  // **************************
  // ***** MÉTODOS EQUALS *****
  // **************************

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }

    if ((obj == null) || (this.getClass() != obj.getClass())) {
      return false;
    }

    final CriterioDeCaja other = (CriterioDeCaja) obj;

    EqualsBuilder eBuilder = new EqualsBuilder();

    eBuilder = eBuilder.append(this.entregasBase, other.entregasBase);
    eBuilder = eBuilder.append(this.entregasCuota, other.entregasCuota);
    eBuilder = eBuilder.append(this.adquisicionesBase, other.adquisicionesBase);
    eBuilder = eBuilder.append(this.adquisicionesCuota, other.adquisicionesCuota);

    return eBuilder.isEquals();
  }

  @Override
  public int hashCode() {

    final HashCodeBuilder hcBuilder = new HashCodeBuilder(17, 31);

    hcBuilder.append(this.entregasBase);
    hcBuilder.append(this.entregasCuota);
    hcBuilder.append(this.adquisicionesBase);
    hcBuilder.append(this.adquisicionesCuota);

    return hcBuilder.toHashCode();
  }

}
