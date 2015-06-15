package tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HolaMundo extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String nombre;
	@Override
	public int doStartTag() {
		return TagSupport.SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspTagException {
		try {
			pageContext.getOut().write("Hola </b>" +this.nombre + "</b>");
		} catch (Exception ex) { throw new JspTagException(ex.toString()); }
		return TagSupport.EVAL_PAGE;
	}
	public String getNombre() { return nombre;}
	public void setNombre(String nombre) { this.nombre = nombre; }

}
