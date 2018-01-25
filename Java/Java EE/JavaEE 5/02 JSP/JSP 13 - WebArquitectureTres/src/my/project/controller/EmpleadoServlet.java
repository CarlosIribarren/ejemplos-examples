package my.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.service.EmpleadoService;
import my.project.service.impl.EmpleadoServiceImpl;

public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpleadoService empleadoService;

	public EmpleadoServlet() {
		super();
		empleadoService = new EmpleadoServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		System.out.println(request.getPathInfo());
		request.setAttribute("empleados", empleadoService.getEmpleados());
		request.getSession().setAttribute("empleados", empleadoService.getEmpleados());
		request.setAttribute("empleado", empleadoService.getEmpleadoByName("carlos11"));
		request.getRequestDispatcher("/WEB-INF/views/empleado/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
