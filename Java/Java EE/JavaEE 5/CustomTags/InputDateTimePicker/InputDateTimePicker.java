import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;


public class InputDateTimePicker extends RequestContextAwareTag {

  // ******************
  // *** CONSTANTES ***
  // ******************

  /** Serial version */
  private static final long serialVersionUID = 1L;

  // ******************
  // *** ATRIBUTOS ****
  // ******************

  /** Atributo del bean al que se asocia el valor de la fecha */
  private String path;

  /** Id del DateTimePicker (por si se quiere ocultar...) */
  private String id;

  /** Clases extra de css para el input */
  private String cssClass;

  /** Read only */
  private Boolean readOnly;

  // ******************
  // **** METODOS ****
  // ******************

  @Override
  public int doStartTagInternal() throws JspException, IOException {

    final JspWriter jspWriter = this.pageContext.getOut();

    jspWriter.write(" <div class='input-group date' ");

    // Id opcional
    if (this.id != null) {
      jspWriter.write(" id='");
      jspWriter.write(this.id);
      jspWriter.write("'");
    }
    jspWriter.write(">");

    final InputDate inputDate = new InputDate();

    // CSS Class
    final StringBuilder cssClassStringBuilder = new StringBuilder("form-control ");
    if (this.cssClass != null) {
      cssClassStringBuilder.append(this.cssClass);
    }

    // Read only
    if (this.readOnly != null) {
      inputDate.setReadonly(this.readOnly);
    }

    inputDate.setCssClass(cssClassStringBuilder.toString());
    inputDate.setCssErrorClass("form-control error");
    inputDate.setPath(this.path);
    inputDate.setPageContext(this.pageContext);
    inputDate.doStartTag();
    inputDate.doEndTag();

    jspWriter.write("<span class='input-group-addon'> <span class='glyphicon glyphicon-calendar'></span></span></div>");

    return SKIP_BODY;
  }

  // ***************************
  // **** METODOS GET Y SET ****
  // ***************************

  /**
   * Establece el campo id
   *
   * @param id Nuevo valor del campo id
   */
  @Override
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Establece el campo path
   *
   * @param path Nuevo valor del campo path
   */
  public void setPath(final String path) {
    this.path = path;
  }

  /**
   * Establece el campo cssClass
   *
   * @param cssClass Nuevo valor del campo cssClass
   */
  public void setCssClass(final String cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Establece el campo readOnly
   *
   * @param readOnly Nuevo valor del campo readOnly
   */
  public void setReadOnly(final Boolean readOnly) {
    this.readOnly = readOnly;
  }

}
