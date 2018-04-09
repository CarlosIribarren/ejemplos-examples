import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Locale;

import Constantes;
import Utils;

import org.springframework.context.i18n.LocaleContextHolder;


/** Conversor de fechas */
public class DateConversor extends PropertyEditorSupport {

  @Override
  public void setAsText(final String text) throws IllegalArgumentException {
    final Locale locale = LocaleContextHolder.getLocale();
    final String datePattern = Constantes.getDatePattern(locale);
    super.setValue(Utils.convertirDate(text, datePattern));
  }

  @Override
  public String getAsText() {
    final Locale locale = LocaleContextHolder.getLocale();
    final Date fecha = (Date) this.getValue();
    return Utils.formatearFecha(fecha, locale);
  }
}
