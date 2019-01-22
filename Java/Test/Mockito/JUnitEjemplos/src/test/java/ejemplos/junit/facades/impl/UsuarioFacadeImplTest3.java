/**Copyright(c)2017,Gipuzkoako Foru Aldundia*Eskubide guztiak erreserbatuta/All rights reserved*/
package ejemplos.junit.facades.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ejemplos.junit.config.AppConfig;
import ejemplos.junit.daos.UsuarioDao;
import ejemplos.junit.facades.UsuarioFacade;


/**
 * Este test utiliza la libreria de Mockito y Spring para instanciar los objs.
 * Se utiliza el fichero de configuracion de JavaConfig, y se cargan los beans Service, Repository,...
 * En la clase de Test se crean los Objs utilizando la anotacion AutoWired de Spring.
 * Con la anotacion Mock se crea el obj UsuarioDao, que sera candidato para ser inyectado.
 * Con la anotacion InjectMocks se crea el obj UsuarioFacadeImpl, donde se inyectara los mocks candidatos.
 */

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioFacadeImplTest3 {

  @Autowired
  @Mock
  private UsuarioDao usuarioDaoMock;

  @Autowired
  @InjectMocks
  private UsuarioFacade usuarioFacade;

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
