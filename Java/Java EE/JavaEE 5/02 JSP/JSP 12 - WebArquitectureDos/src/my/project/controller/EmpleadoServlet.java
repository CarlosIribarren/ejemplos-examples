package my.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.dao.EmpleadoDAO;
import my.project.dao.impl.EmpleadoDAOImpl;

public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpleadoDAO empleadoDAO;;

	public EmpleadoServlet() {
		super();
		empleadoDAO = new EmpleadoDAOImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		System.out.println(request.getPathInfo());
		request.setAttribute("empleados", empleadoDAO.findAll());
		request.getSession().setAttribute("empleados", empleadoDAO.findAll());
		request.setAttribute("empleado", empleadoDAO.getById("carlos11"));
		request.getRequestDispatcher("/WEB-INF/views/empleado/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
