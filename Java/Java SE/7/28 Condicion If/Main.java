package pruebas;

public class Main {

  public static void main(final String[] args) {

    final Persona persona = new Persona();
    persona.setCodigo(null);
    persona.setNombre(null);

    try {

      if ((persona != null) && (persona.getCodigo() != null) && (persona.getCodigo() != 1)) {

        System.out.println("Evaluacion correcta.");

      } else {

        System.out.println(" - Se evalua la siguiente expresion :\n");
        System.out
            .println(" ------------------------------------------------------------------------------------------\n ");
        System.out.println("       final Persona persona = new Persona(); ");
        System.out.println("       persona.setCodigo(null); ");
        System.out.println("       persona.setNombre(null); \n");
        System.out
            .println(" ------------------------------------------------------------------------------------------\n ");
        System.out
            .println(" ******************************************************************************************* ");
        System.out.println(" if ( (persona != null) && (persona.getCodigo() != null) && (persona.getCodigo() != 1) ) ");
        System.out
            .println(" *******************************************************************************************\n ");
        System.out.println(" La evaluacion de la expresion se realiza de izquierda a derecha:");
        System.out.println("     - Si la evaluacion es correcta, se evalua la segunda expresion. ");
        System.out.println(
            "     - Si la evaluacion es incorrecta, se para la evaluacion y no se sigue evaluando hacia la izquierda.\n");

        System.out.println(" 1.- Evalua la  primera expresion : (persona != null) ");

        System.out.println("     - Como la evaluacion ha sido correcta, se sigue evaluando la siguiente condicion ");
        System.out.println(" 2.- Evalua la segunda expresion : (persona.getCodigo() != null) ");
        System.out.println(
            "     - Como la evaluacion ha sido incorrecta, no se sigue evaluando la siguiente condicion y se para.\n\n ");

        System.out.println(" NOTA : Si se la condicion se hubiera escrito en el siguiente orden, ");
        System.out.println(
            " --------------------------------------------------------------------------------------------------- ");
        System.out.println(
            "         if ( (persona != null) && (persona.getCodigo() != 1) && (persona.getCodigo() != null) ) ");
        System.out.println(
            " --------------------------------------------------------------------------------------------------- ");
        System.out.println(
            " La evaluacion de la expresion hubiera producido un NullPointer, ya que, se estaria intentando comparar el 'codigo' con el numero 1, cuando el 'codigo' es null.");
      }

    } catch (final Exception e) {
      System.out.println(" Error al evaluar la expresion. ");
    }

  }

}
