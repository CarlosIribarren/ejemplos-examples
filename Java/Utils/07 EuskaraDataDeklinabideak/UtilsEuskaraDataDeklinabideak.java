
import java.util.Calendar;
import java.util.Date;


/**
 * Clase de utils que realiza la declinacion correcta de una fecha en Euskera.
 *
 */
public final class UtilsEuskaraDataDeklinabideak {

  // ***********************
  // ***** CONSTANTES ******
  // ***********************

  /** Meses en Euskera */
  private static final String[] BASQUE_MONTHS = { "urtarrila", "otsaila", "martxoa", "apirila", "maiatza", "ekaina",
      "uztaila", "abuztua", "iraila", "urria", "azaroa", "abendua" };

  // ***********************
  // ***** CONSTRUCTOR *****
  // ***********************

  /** Constructor privado */
  private UtilsEuskaraDataDeklinabideak() {
  }

  // ***********************
  // *** METODOS PUBLICOS **
  // ***********************

  /**
   * Obtener una fecha con la declinacion correcta en Euskera, se recibe la fecha como parametro.
   *
   * @param data Fecha
   * @return Retorna una fecha con la declinacion correcta en Euskera
   */
  public static String dataDeklinatu(final Date data) {

    // Emaitza prestatu
    final StringBuilder dataDeklinatuta = new StringBuilder("");

    if (data != null) {

      final Calendar cal = Calendar.getInstance();
      cal.setTime(data);

      // Urtea deklinatu
      final int urtea = cal.get(Calendar.YEAR);
      final String urteaDeklinatuta = urteaDeklinatu(urtea);
      if (urteaDeklinatuta != null) {
        dataDeklinatuta.append(urteaDeklinatuta);
      }

      // Hilabetea deklinatu
      final int hilabetea = cal.get(Calendar.MONTH);
      final String hilabeteaDeklinatuta = hilabeteaDeklinatu(hilabetea);
      dataDeklinatuta.append(" ").append(hilabeteaDeklinatuta).append(" ");

      // Eguna deklinatu
      final int eguna = cal.get(Calendar.DAY_OF_MONTH);
      final String egunaDeklinatuta = egunaDeklinatu(eguna);
      if (egunaDeklinatuta != null) {
        dataDeklinatuta.append(egunaDeklinatuta);
      }
    }

    return dataDeklinatuta.toString();
  }

  // ***********************
  // *** METODOS PRIVADOS **
  // ***********************

  /**
   * Obtener un año con la declinacion correcta en Euskera, se recibe el ejercicio como paramtero.
   *
   * @param u Ejercicio
   * @return Retorna un año con la declinacion correcta en Euskera
   */
  private static String urteaDeklinatu(final int u) {

    // Emaitza prestatu
    final StringBuilder urteaDeklinatuta = new StringBuilder("");
    final String urtea = String.valueOf(u);
    urteaDeklinatuta.append(urtea);

    final String azkenZenbakia = urtea.substring(3, 4);
    final String azkenBiZenbakiak = urtea.substring(2, 4);

    if ("5".equals(azkenZenbakia)) {
      urteaDeklinatuta.append("eko");
    } else {
      switch (azkenBiZenbakiak) {
        case "10":
        case "30":
        case "50":
        case "70":
        case "90":
        case "01":
        case "21":
        case "41":
        case "61":
        case "81":
          urteaDeklinatuta.append("eko");
          break;
        default:
          urteaDeklinatuta.append("ko");
          break;
      }
    }

    return urteaDeklinatuta.toString();
  }

  /**
   * Obtener un mes con la declinacion correcta en Euskera, se recibe el numnero del mes como paramtero.
   *
   * @param h Numero del mes
   * @return Retorna un mes con la declinacion correcta en Euskera
   */
  private static String hilabeteaDeklinatu(final int h) {
    final StringBuilder hilabeteaDeklinatuta = new StringBuilder("");
    hilabeteaDeklinatuta.append(BASQUE_MONTHS[h]).append("ren");
    return hilabeteaDeklinatuta.toString();
  }

  /**
   * Obtener un dia con la declinacion correcta en Euskera, se recibe el numnero de dia como paramtero.
   *
   * @param e Numero de dia
   * @return Retorna un dia con la declinacion correcta en Euskera
   */
  private static String egunaDeklinatu(final int e) {

    // Emaitza prestatu
    final StringBuilder egunaDeklinatuta = new StringBuilder("");
    final String eguna = String.valueOf(e);
    egunaDeklinatuta.append(eguna);

    switch (e) {
      case 11:
      case 31:
        egunaDeklinatuta.append("n");
        break;
      case 1:
      case 5:
      case 10:
      case 15:
      case 21:
      case 25:
      case 30:
        egunaDeklinatuta.append("ean");
        break;
      default:
        egunaDeklinatuta.append("an");
        break;
    }

    return egunaDeklinatuta.toString();
  }

}
