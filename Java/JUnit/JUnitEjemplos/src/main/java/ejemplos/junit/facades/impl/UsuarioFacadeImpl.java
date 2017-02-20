
package ejemplos.junit.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplos.junit.daos.UsuarioDao;
import ejemplos.junit.facades.UsuarioFacade;


@Service
public class UsuarioFacadeImpl implements UsuarioFacade {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  @Autowired
  private UsuarioDao usuarioDao;

  // *****************
  // ** CONSTRUCTOR **
  // *****************

  public UsuarioFacadeImpl() {
  }

  public UsuarioFacadeImpl(final UsuarioDao usuarioDao) {
    super();
    this.usuarioDao = usuarioDao;
  }

  // *****************
  // **** METODOS ****
  // *****************

  public void holaMundoJUnitAndMock(final int id) {

    final String nombre = this.usuarioDao.getNombre(id);
    System.out.println("Hola mundo " + nombre);

  }

}
