/**Copyright(c)2017,Gipuzkoako Foru Aldundia*Eskubide guztiak erreserbatuta/All rights reserved*/
package ejemplos.junit.facades.impl;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import ejemplos.junit.bean.CriterioDeCaja;
import ejemplos.junit.daos.CriterioDeCajaDao;
import ejemplos.junit.facades.CriterioDeCajaFacade;


/***
 * @author EuroHelp S.L.
 */
@RunWith(value = Parameterized.class)
public class CriterioDeCajaFacadeImplTest {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  /** Facade de Criterio De Caja */
  private final CriterioDeCajaFacade criterioDeCajaFacade;

  // ********************************
  // *** ATRIBUTOS PARAMETRIZADOS ***
  // ********************************

  /**
   * Atributo parametrizado que sirve como parametro de entrada del metodo
   * "CriterioDeCaja asignarValoresSinActividad(CriterioDeCaja criterioDeCaja)"
   */
  private final CriterioDeCaja criterioDeCajaEntrada;

  /**
   * Atributo parametrizado que sirve como resultado del metodo
   * "CriterioDeCaja asignarValoresSinActividad(CriterioDeCaja criterioDeCaja)"
   */
  private final CriterioDeCaja criterioDeCajaSalida;

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  public CriterioDeCajaFacadeImplTest(final CriterioDeCaja criterioDeCajaEntrada,
      final CriterioDeCaja criterioDeCajaSalida) {
    this.criterioDeCajaEntrada = criterioDeCajaEntrada;
    this.criterioDeCajaSalida = criterioDeCajaSalida;
    this.criterioDeCajaFacade = new CriterioDeCajaFacadeImpl();
  }

  // *****************
  // ** PARAMETROS ***
  // *****************

  /**
   * Se inicializan los datos para todos los métodos
   *
   * @return Se retorna una colección de objetos
   */
  @Parameters
  public static Collection<Object[]> data() {

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++ * Prueba 0 : Realizada con numeros pequeños (3 digitos)
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ******* Entrada CriterioDeCaja 0 *************
    final CriterioDeCaja criterioDeCajaEntrada0 = new CriterioDeCaja();
    criterioDeCajaEntrada0.setEntregasBase(new Double(558));
    criterioDeCajaEntrada0.setEntregasCuota(new Double(647));
    criterioDeCajaEntrada0.setAdquisicionesBase(new Double(982));
    criterioDeCajaEntrada0.setAdquisicionesCuota(new Double(229));

    // ******* Salida CriterioDeCaja 0 *************
    final CriterioDeCaja criterioDeCajaSalida0 = new CriterioDeCaja();
    criterioDeCajaSalida0.setEntregasBase(new Double(0));
    criterioDeCajaSalida0.setEntregasCuota(new Double(0));
    criterioDeCajaSalida0.setAdquisicionesBase(new Double(0));
    criterioDeCajaSalida0.setAdquisicionesCuota(new Double(0));

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++ * Prueba 1 : Realizada con numeros medianos (5 digitos)
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ******* Entrada CriterioDeCaja 1 *************
    final CriterioDeCaja criterioDeCajaEntrada1 = new CriterioDeCaja();
    criterioDeCajaEntrada1.setEntregasBase(new Double(51298));
    criterioDeCajaEntrada1.setEntregasCuota(new Double(74125));
    criterioDeCajaEntrada1.setAdquisicionesBase(new Double(96325));
    criterioDeCajaEntrada1.setAdquisicionesCuota(new Double(85214));

    // ******* Salida CriterioDeCaja 1 *************
    final CriterioDeCaja criterioDeCajaSalida1 = new CriterioDeCaja();
    criterioDeCajaSalida1.setEntregasBase(new Double(0));
    criterioDeCajaSalida1.setEntregasCuota(new Double(0));
    criterioDeCajaSalida1.setAdquisicionesBase(new Double(0));
    criterioDeCajaSalida1.setAdquisicionesCuota(new Double(0));

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++ * Prueba 2 : Realizada con numeros medianos (8 digitos)
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ******* Entrada CriterioDeCaja 2 *************
    final CriterioDeCaja criterioDeCajaEntrada2 = new CriterioDeCaja();
    criterioDeCajaEntrada2.setEntregasBase(new Double(54562298));
    criterioDeCajaEntrada2.setEntregasCuota(new Double(74226325));
    criterioDeCajaEntrada2.setAdquisicionesBase(new Double(98746325));
    criterioDeCajaEntrada2.setAdquisicionesCuota(new Double(85226954));

    // ******* Salida CriterioDeCaja 2 *************
    final CriterioDeCaja criterioDeCajaSalida2 = new CriterioDeCaja();
    criterioDeCajaSalida2.setEntregasBase(new Double(0));
    criterioDeCajaSalida2.setEntregasCuota(new Double(0));
    criterioDeCajaSalida2.setAdquisicionesBase(new Double(0));
    criterioDeCajaSalida2.setAdquisicionesCuota(new Double(0));

    // Asignar los datos
    final Object[][] data = new Object[][] { { criterioDeCajaEntrada0, criterioDeCajaSalida0 },
        { criterioDeCajaEntrada1, criterioDeCajaSalida1 }, { criterioDeCajaEntrada2, criterioDeCajaSalida2 } };

    return Arrays.asList(data);
  }

  // *****************
  // **** METODOS ****
  // *****************

  /**
   * Test que prueba el metodo "void asignarValoresSinActividad(CriterioDeCaja criterioDeCaja)"
   * Este test prueba el funcionamiento normal del metodo, con diferentes datos
   */
  @Test
  public final void testAsignarValoresSinActividad() {

    // Probar el metodo
    this.criterioDeCajaFacade.asignarValoresSinActividad(this.criterioDeCajaEntrada);

    // Entregas Base
    Assert.assertEquals("El Double de Entregas Base no es igual!!!", this.criterioDeCajaSalida.getEntregasBase(),
        this.criterioDeCajaEntrada.getEntregasBase());

    // Entregas Cuota
    Assert.assertEquals("El Double de Entregas Cuota no es igual!!!", this.criterioDeCajaSalida.getEntregasCuota(),
        this.criterioDeCajaEntrada.getEntregasCuota());

    // Adquisiciones Base
    Assert.assertEquals("El Double de Adquisiciones Base no es igual!!!",
        this.criterioDeCajaSalida.getAdquisicionesBase(), this.criterioDeCajaEntrada.getAdquisicionesBase());

    // Adquisiciones Cuota
    Assert.assertEquals("El Double de Adquisiciones Cuota no es igual!!!",
        this.criterioDeCajaSalida.getAdquisicionesCuota(), this.criterioDeCajaEntrada.getAdquisicionesCuota());

    // Criterio De Caja
    Assert.assertEquals("El objeto de criterio De Caja no es igual", this.criterioDeCajaSalida,
        this.criterioDeCajaEntrada);

    // Comparar el resultado despues de ejecutar el metodo
    Assert.assertTrue(this.criterioDeCajaSalida.equals(this.criterioDeCajaEntrada));
  }

  @Test
  public final void testObtenerYSumar1() {

    // Preparar resultado
    final CriterioDeCaja criterioDeCajaPreparado = new CriterioDeCaja();
    criterioDeCajaPreparado.setAdquisicionesBase(new Double(2));
    criterioDeCajaPreparado.setAdquisicionesCuota(new Double(2));
    criterioDeCajaPreparado.setEntregasBase(new Double(2));
    criterioDeCajaPreparado.setEntregasCuota(new Double(2));

    // Preparar llamada y respuesta
    final CriterioDeCajaDao criterioDeCajaDao = Mockito.mock(CriterioDeCajaDao.class);
    Mockito.when(criterioDeCajaDao.getCriterioDeCaja(1)).thenReturn(criterioDeCajaPreparado);

    final CriterioDeCaja criterioDeCajaRespuesta = this.criterioDeCajaFacade.obtenerYSumar1(1);

    Assert.assertEquals("El objeto Criterio de Caja no es igual!!!", criterioDeCajaPreparado, criterioDeCajaRespuesta);

  }

  // **********************************
  // **** CASOS ESPECIALES DE NULL ****
  // **********************************

  /**
   * Test que prueba el metodo "void asignarValoresSinActividad(CriterioDeCaja criterioDeCaja)"
   * Este test prueba que si le pasamos null como argumento, lanza la excepcion ZergaBideaException
   */
  @Test(expected = NullPointerException.class)
  public final void testAsignarValoresSinActividadNull() {
    this.criterioDeCajaFacade.asignarValoresSinActividad(null);
  }

}
