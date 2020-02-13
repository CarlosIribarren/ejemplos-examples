package oiasso.system.listadocoches.datatables.front.beans;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FiltroCoche {

	// *********************
	// ***** Atributos *****
	// *********************

	/** Fecha de nacimiento */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaInicio;

	/** Fecha de nacimiento */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaFin;

	// *********************
	// ***** Constructor ***
	// *********************

	public FiltroCoche() {
		super();
	}

	public FiltroCoche(LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	// *********************
	// ** Getter y Setter **
	// *********************

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

}
