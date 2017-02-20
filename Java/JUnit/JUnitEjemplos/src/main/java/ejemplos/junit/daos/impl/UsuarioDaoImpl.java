/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package ejemplos.junit.daos.impl;

import org.springframework.stereotype.Repository;

import ejemplos.junit.daos.UsuarioDao;


@Repository
public class UsuarioDaoImpl implements UsuarioDao {

  public UsuarioDaoImpl() {
  }

  public String getNombre(final int id) {
    return "sin utilizar Mocks!!!";
  }

}
