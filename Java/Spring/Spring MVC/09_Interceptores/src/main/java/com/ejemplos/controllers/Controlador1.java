/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package com.ejemplos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controlador1 {

  @RequestMapping(value = { "/inicio", "/pagina1" })
  public String pagina1(final Model model, final HttpSession sesion) {
    return "index";
  }

  @RequestMapping(value = "/pagina2")
  public String pagina2(final Model model, final HttpSession sesion) {
    return "index2";
  }

  @RequestMapping(value = "/pagina3")
  public String pagina3(final Model model, final HttpSession sesion) {
    return "index3";
  }

}
