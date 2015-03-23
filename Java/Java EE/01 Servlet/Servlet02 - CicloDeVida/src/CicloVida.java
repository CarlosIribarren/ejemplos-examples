import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CIcloVida")
public class CicloVida extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw ;
	String texto;
	Integer numeroPeticion;
	
    public CicloVida() {
        super();
    }
    
    // ------------------- METODO 1 ------------------------------
    //-------------------------------------------------------------
	@Override
	public void init() throws ServletException {

		super.init();
		// El metodo init solo se ejecuta una vez
		// Importante llamar al padre (super) 
		// este es el primer metodo que se ejecuta
		// este metodo sirve para iniciar variables,...
		numeroPeticion=0;
		texto="1.- init es el primer metodo";
		
	}
	
    // ------------------- METODO 2 ------------------------------
    //-------------------------------------------------------------
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// Cada vez que se recibe una peticion se ejecuta
		// en funcion de la peticion que recibe ( get / post) nos redirigira al metodo oportuno ( doGet / doPost )
		//cada vez que se hace una llamada el String se rellena con una linea mas
		// la variabe String ira concatenando la frase nueva cada vez que se hace una peticion
		// esto sucedera hasta que se pare el servidor.
		numeroPeticion=numeroPeticion+1;
		texto = texto + "<br>2.- " + numeroPeticion + " Llamada al metodo Service";
		super.service(arg0, arg1);
		
	}

    // ------------------- METODO 3 ------------------------------
    //-------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pw = response.getWriter();
		pw.print("<html><body>");
		pw.print("<h1>Ciclo de Vida de Servlet</h1>");
		pw.print("<p>" + texto + "</p>");
		pw.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    // ------------------- METODO 4 ------------------------------
    //-------------------------------------------------------------
	@Override
	public void destroy() {
		// Todo lo que hemos iniciado en INIT deveriamos de cerrarlo.
		texto="";
		numeroPeticion=0;
		pw=null;
		
		super.destroy();
	}
	

}
