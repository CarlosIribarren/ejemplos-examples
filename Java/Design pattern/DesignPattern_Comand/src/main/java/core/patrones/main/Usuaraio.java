/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package core.patrones.main;

import java.util.Scanner;

import core.patrones.comando.Comando;
import core.patrones.comandos.ComandoAumentarCambio;
import core.patrones.comandos.ComandoDisminuirCambio;
import core.patrones.invocador.PanelFrontal;
import core.patrones.utils.Impresor;


/**
 * Este patron permite solicitar una operacion a un objeto sin conocer realmente el contenido de esa operacion. Ni el
 * receptor real de la misma.
 * El Usuario es el cliente.
 * El cliente iteractua directamente con las ordenes concretas, los Comandos.
 * El cliente no conoze el receptor, pero al utilizar las ordenes concretas, internamente modifica el receptor.
 *
 * @author ciribarren
 */
public class Usuaraio {

  public static void main(final String[] args) {

    final PanelFrontal panelFrontal = new PanelFrontal();

    final Scanner sc = new Scanner(System.in);
    final Impresor visor = new Impresor();

    Comando a = null;

    visor.imprimir("Presiona a para aumentar un cambio y b para disminuirlo");
    switch (sc.nextLine()) {
      case "a":
        a = new ComandoAumentarCambio();
        break;
      case "b":
        a = new ComandoDisminuirCambio();
        break;
      default:
        break;
    }

    // Asignar el comando
    panelFrontal.asignarComnando(a);

    panelFrontal.palancaAccionada();

  }

}
