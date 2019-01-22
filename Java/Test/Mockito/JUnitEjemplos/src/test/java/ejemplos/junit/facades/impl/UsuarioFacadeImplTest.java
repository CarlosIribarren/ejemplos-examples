/**Copyright(c)2017,Gipuzkoako Foru Aldundia*Eskubide guztiak erreserbatuta/All rights reserved*/
package ejemplos.junit.facades.impl;

import org.junit.Test;
import org.mockito.Mockito;

import ejemplos.junit.daos.UsuarioDao;
import ejemplos.junit.facades.UsuarioFacade;


/**
 * Este test solo utiliza la libreria de Mockito. NO se usa Spring para instanciar los objs.
 * Se crean los Objs utilizando JavaSE. Primero se crea el obj Mock y luego se crea el objeto donde se quiere injectar
 * el Mock. Al crear el objeto donde se quiere instanciar el Mock, se hace utilizando el constructor y se le pasa como
 * parametro el Mock.
 * ********************************************************************
 * ****** usuarioFacade = new UsuarioFacadeImpl(usuarioDaoMock); ******
 * ********************************************************************
 */
public class UsuarioFacadeImplTest {

  @Test
  public void testHolaMundoJUnitAndMock() {

    UsuarioFacade usuarioFacade;
    UsuarioDao usuarioDaoMock;

    usuarioDaoMock = Mockito.mock(UsuarioDao.class);
    usuarioFacade = new UsuarioFacadeImpl(usuarioDaoMock);

    Mockito.when(usuarioDaoMock.getNombre(1)).thenReturn(new String(" utilizando Mocks!!!"));

    usuarioFacade.holaMundoJUnitAndMock(1);
  }

}
