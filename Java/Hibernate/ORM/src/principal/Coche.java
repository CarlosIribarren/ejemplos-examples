package principal;

public class Coche extends Vehiculo {

	private Empleado empleado;
	private Empresa empresa;
	
	@Override
	public Integer getNumeroPlazas() {
		return null;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
}
