package com.innova4b.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innova4b.servicio.ServicioEJB;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ServicioEJB bean;

    public Servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Servlet b&aacute;sico llamando a EJB</h2>");

		bean.enviarMensaje("Hasta luego Mundo");
		
		out.println("</body></html>");
	}

}
