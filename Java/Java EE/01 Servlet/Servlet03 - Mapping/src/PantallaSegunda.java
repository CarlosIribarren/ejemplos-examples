

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PantallaSegunda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PantallaSegunda() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>"
				+ "<html lang=\"es\">"
					+ "<head>"
						+ "<title>Segunda Pantalla</title>"
					+ "</head>"
				+ "<body>"
					+ "<p>Segunda Pantalla !!!!</p>"
					+ "<a href=\"inicio\" > inicio </a>"
					+ "<br>"
					+ "<a href=\"segundaPantalla\" > Segunda Pantalla </a>"
				+ "</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
