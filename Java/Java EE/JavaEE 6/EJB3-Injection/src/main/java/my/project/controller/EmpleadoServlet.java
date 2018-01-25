package my.project.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.ejbService.EmpleadoService;
import my.project.ejbService.impl.EmpleadoServiceImpl;

public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//definimos el EJB => automaticamente se carga ( sin instanciar )
	@EJB   
	EmpleadoService bean;

	public EmpleadoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		System.out.println(request.getPathInfo());
		
		
		//AÑADIR ATRIBUTOS A LA SESION Y AL REQUEST
		List list = bean.getEmpleados();
		request.setAttribute("empleados", list);
		request.getSession().setAttribute("empleados", bean.getEmpleados());
		request.setAttribute("empleado", bean.getEmpleadoByName("carlos11"));
		
		//REDIRIGIR PASANDO ATRIBUTOS
		request.getRequestDispatcher("/WEB-INF/views/empleado/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
