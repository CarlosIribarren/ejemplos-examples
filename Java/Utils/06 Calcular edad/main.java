import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class main {

  public static void main(final String[] args) {

    // Probar el calculo de la edad
    final DateUtils dateUtils = new DateUtils();
    // Generar una fecha
    Date hoy = null;
    try {
      hoy = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1984-08-08 00:00:00");
    } catch (final ParseException e) {
      e.printStackTrace();
    }
    // Calcular la edad
    final int edad = dateUtils.calcularEdad(hoy);
    System.out.println(edad);
  }

}
