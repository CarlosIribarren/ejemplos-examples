package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanPersona;

public class ServletFormulario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public ServletFormulario() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recibir parametros desde el html
		String nombre = (String) request.getParameter("nombre");
		BeanPersona p = new BeanPersona();
		p.setNombre(nombre);
		request.setAttribute("persona", p);
		System.out.println(nombre);
		request.getRequestDispatcher("MostrarDatos.jsp").forward(request, response);
		
	}

}
