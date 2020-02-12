package oiasso.system.examples.jpa.datatables.helpers;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.ObjectError;

import oiasso.system.examples.jpa.datatables.beans.Persona;

public class DataTablesPersonaOutput {

	/** Parametro de seguridad **/
	private int draw;

	/** Parametro de seguridad **/
	private long recordsTotal = 0L;

	/** Parametro de seguridad **/
	private long recordsFiltered = 0L;

	/** Parametro de seguridad **/
	private List<Persona> data = Collections.emptyList();

	private String error;

	private List<ObjectError> errorsFilter;

	public DataTablesPersonaOutput(RestResponsePersonaPage responsePage, int draw) {
		super();
		this.draw = draw;
		this.recordsTotal = responsePage.getElementOfPage();
		this.recordsFiltered = responsePage.getTotalElements();
		this.data = responsePage.getData();
	}

	public DataTablesPersonaOutput(int draw) {
		super();
		this.draw = draw;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<Persona> getData() {
		return data;
	}

	public void setData(List<Persona> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<ObjectError> getErrorsFilter() {
		return errorsFilter;
	}

	public void setErrorsFilter(List<ObjectError> errorsFilter) {
		this.errorsFilter = errorsFilter;
	}

}
