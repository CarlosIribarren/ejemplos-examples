package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Persona;


public class ServletDos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDos() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Persona p = new Persona();
		String cadenarecibida = request.getParameter("nombre");
		p.setNombre(cadenarecibida);
		System.out.println(cadenarecibida);
		request.setAttribute("personaAtributo",p );
		request.getRequestDispatcher("mostrar.jsp").forward(request, response);
		
		
	}

}
