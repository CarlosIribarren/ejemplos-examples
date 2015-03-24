import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SegundaPantalla")
public class SegundaPantalla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SegundaPantalla() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>"
				+ "<html lang=\"es\">"
					+ "<head>"
						+ "<title>Mapping con anotaciones - SegundaPantalla</title>"
					+ "</head>"
				+ "<body>"
					+ "<p>Mapping con anotaciones - SegundaPantalla!!!!</p>"
					+ "<a href=\"PrimeraPantalla\" > inicio </a>"
					+ "<br>"
					+ "<a href=\"SegundaPantalla\" > Segunda Pantalla </a>"
				+ "</body>"
				+ "</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
