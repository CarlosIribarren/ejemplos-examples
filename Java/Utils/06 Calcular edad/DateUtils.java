
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

  /**
   * Calcula la edad en base a una fecha
   *
   * @param date Fecha
   * @return Retorna la edad
   */
  public int calcularEdad(final Date date) {

    final Calendar fechaNac = this.toCalendar(date);

    final Calendar today = Calendar.getInstance();

    int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
    final int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
    final int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

    // Si está en ese año pero todavía no los ha cumplido
    if ((diffMonth < 0) || ((diffMonth == 0) && (diffDay < 0))) {
      diffYear = diffYear - 1;
    }
    return diffYear;
  }

  /**
   * Convierte una fecha en un obj Calendar
   *
   * @param date
   * @return
   */
  private Calendar toCalendar(final Date date) {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

}
