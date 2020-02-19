package oiasso.system.listadocoches.datatables.front.generics;

import java.util.Collection;
import java.util.Collections;

import org.springframework.hateoas.PagedModel;

public class DataTablesOutput<T> {

	// *********************
	// ***** Atributos *****
	// *********************

	/** Parametro de seguridad **/
	private int draw;

	/** recordsTotal **/
	private long recordsTotal = 0L;

	/** recordsFiltered **/
	private long recordsFiltered = 0L;

	/** Parametro de seguridad **/
	private Collection<T> data = Collections.emptyList();

	/** Error **/
	private String error;

	// *********************
	// **** Constructor ****
	// *********************

	public DataTablesOutput(int draw) {
		super();
		this.draw = draw;
	}

	public DataTablesOutput(PagedModel<T> pagedModel, int draw) {
		this.draw = draw;
		this.setData(pagedModel.getContent());
		this.setRecordsTotal(pagedModel.getMetadata().getSize());
		this.setRecordsFiltered(pagedModel.getMetadata().getTotalElements());
	}

	public DataTablesOutput(String error, Integer draw) {
		this.draw = draw;
		this.error = error;
	}

	// *********************
	// ** Getter y Setter **
	// *********************

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

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
