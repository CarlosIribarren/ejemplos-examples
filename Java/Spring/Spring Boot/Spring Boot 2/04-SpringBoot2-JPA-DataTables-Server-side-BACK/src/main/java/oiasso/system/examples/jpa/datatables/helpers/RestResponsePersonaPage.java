package oiasso.system.examples.jpa.datatables.helpers;

import java.util.List;

import oiasso.system.examples.jpa.datatables.beans.Persona;

public class RestResponsePersonaPage {

	private List<Persona> data;

	private int numberOfPage;

	private int elementOfPage;

	private Long totalElements;

	private int totalPages;

	public RestResponsePersonaPage(List<Persona> data, int elementOfPage, Long totalElements, int totalPages,
			int numberOfPage) {
		super();
		this.data = data;
		this.elementOfPage = elementOfPage;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.numberOfPage = numberOfPage;
	}

	public List<Persona> getData() {
		return data;
	}

	public void setData(List<Persona> data) {
		this.data = data;
	}

	public int getElementOfPage() {
		return elementOfPage;
	}

	public void setElementOfPage(int elementOfPage) {
		this.elementOfPage = elementOfPage;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

}