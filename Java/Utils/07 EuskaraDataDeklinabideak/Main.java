import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

  /**
   * @param args
   */
  public static void main(final String[] args) {


    final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    // Convertir en Date
    Date fecha2 = new Date();
    final String s2 = new String("20171010");
    try {
      fecha2 = formatter.parse(s2);
    } catch (final ParseException e) {
    }

    System.out.println(UtilsEuskaraDataDeklinabideak.dataDeklinatu(fecha2));

  }

}
