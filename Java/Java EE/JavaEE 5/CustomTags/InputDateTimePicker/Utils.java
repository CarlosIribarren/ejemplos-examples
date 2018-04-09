
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Utils {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);


  /**
   * Convierte un String en un objeto tipo Date.
   *
   * @param pattern
   *          Patron de conversion
   * @return Retorna la fecha como un objeto de tipo Date.
   */
  public static Date convertirDate(final String fecha, final String pattern) {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date fechaDate = null;
    try {
      fechaDate = simpleDateFormat.parse(fecha);
    } catch (final ParseException ex) {
      LOGGER.debug("Error al convertir la fecha: " + fecha);
    }
    return fechaDate;
  }

  /**
   * Formatea una fecha para el locale EU o ES.
   *
   * @param date
   *          Fecha para formatear
   * @param locale
   *          Locale al que se quiere formatear
   * @return Retorna la fecha formateada con el locale dado.
   */
  public static String formatearFecha(final Date fecha, final Locale locale) {
    String fechaString = null;
    if (fecha != null) {
      final SimpleDateFormat simpleDateFormat = Constantes.getSimpleDateFormat(locale);
      fechaString = simpleDateFormat.format(fecha);
    }
    return fechaString;
  }

  
  
  
  
  
  
  
  
  

}
