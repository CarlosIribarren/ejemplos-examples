import java.util.Locale;

import javax.servlet.jsp.JspException;

import Constantes;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.tags.form.InputTag;
import org.springframework.web.servlet.tags.form.TagWriter;


public final class InputDate extends InputTag {

  private static final long serialVersionUID = 1L;

  @Override
  protected void writeDefaultAttributes(final TagWriter tagWriter) throws JspException {
    final Locale locale = LocaleContextHolder.getLocale();
    super.writeDefaultAttributes(tagWriter);
    this.writeOptionalAttribute(tagWriter, "placeholder", Constantes.getDatePlaceHolder(locale));
  }

}
