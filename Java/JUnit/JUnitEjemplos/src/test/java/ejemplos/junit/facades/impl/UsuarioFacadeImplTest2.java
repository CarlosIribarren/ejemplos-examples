/**Copyright(c)2017,Gipuzkoako Foru Aldundia*Eskubide guztiak erreserbatuta/All rights reserved*/
package ejemplos.junit.facades.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import ejemplos.junit.daos.UsuarioDao;


/**
 * Este test solo utiliza la libreria de Mockito. NO se usa Spring para instanciar los objs.
 * Se crean los Objs utilizando JavaSE.
 * Con la anotacion Mock se crea el obj UsuarioDao, que sera candidato para ser inyectado.
 * Con la anotacion InjectMocks se crea el obj UsuarioFacadeImpl, donde se inyectara los mocks candidatos.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioFacadeImplTest2 {

  /**
   * Este es el Dao que se quiere Mockear.
   * Su comportamiento se define mas abajo
   */
  @Mock
  private UsuarioDao usuarioDaoMock;

  /**
   * Este es el facade que se quiere probar.
   * Se tiene que instaciar la implementacion de la interface.
   */
  @InjectMocks
  private UsuarioFacadeImpl usuarioFacade;

  /**
   * Se restablece el objeto de prueba y reinicializa los simulacros, antes de cada test
   */
  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testHolaMundoJUnitAndMock() {

    Mockito.when(this.usuarioDaoMock.getNombre(1)).thenReturn(new String(" utilizando Mocks!!!"));

    this.usuarioFacade.holaMundoJUnitAndMock(1);
  }

}
