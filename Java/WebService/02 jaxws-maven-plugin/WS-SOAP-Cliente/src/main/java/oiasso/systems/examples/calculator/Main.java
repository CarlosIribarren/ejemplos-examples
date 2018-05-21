package oiasso.systems.examples.calculator;

import oiasso.systems.examples.calculator.soap.Calculator;
import oiasso.systems.examples.calculator.soap.CalculatorSoap;


public class Main {

  /**
   * @param args
   */
  public static void main(final String[] args) {

    // Obtener instancia del servicio
    final CalculatorSoap calculatorSoap = new Calculator().getCalculatorSoap();

    // Llamar al WS
    final int resultadoSuma = calculatorSoap.add(1, 2);

    // Visualizar el resultado
    System.out.println("Resultado de la Suma:" + resultadoSuma);

  }

}
