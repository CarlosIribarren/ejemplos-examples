import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class Constantes {

  public static final Locale SPANISH_LOCALE = new Locale("es", "ES");

  public static final Locale BASQUE_LOCALE = new Locale("eu", "ES");

  public static final String SPANISH_DATE_PATTERN = "dd/MM/yyyy";

  public static final String BASQUE_DATE_PATTERN = "yyyy/MM/dd";

  public static final String SPANISH_DATE_PLACEHOLDER = "DD/MM/AAAA";

  public static final String BASQUE_DATE_PLACEHOLDER = "UUUU/HH/EE";

  
    /**
   * Recupera el patron (pattern) en función del locale.
   *
   * @param locale Locale del que se quiere el patron (pattern)
   * @return Retorna el patron (pattern) del locale dado.
   */
  public static String getDatePattern(final Locale locale) {
    if (BASQUE_LOCALE.equals(locale)) {
      return BASQUE_DATE_PATTERN;
    } else {
      return SPANISH_DATE_PATTERN;
    }
  }
  
  /**
   * Recupera el placeholder en función del locale.
   *
   * @param locale Locale del que se quiere el placeholder
   * @return Retorna el placeholder del locale dado.
   */
  public static String getDatePlaceHolder(final Locale locale) {
    if (BASQUE_LOCALE.equals(locale)) {
      return BASQUE_DATE_PLACEHOLDER;
    } else {
      return SPANISH_DATE_PLACEHOLDER;
    }
  }


}
