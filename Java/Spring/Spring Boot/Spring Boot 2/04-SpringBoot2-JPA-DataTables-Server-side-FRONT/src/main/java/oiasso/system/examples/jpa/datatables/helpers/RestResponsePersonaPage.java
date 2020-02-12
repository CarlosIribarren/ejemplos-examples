package oiasso.system.examples.jpa.datatables.helpers;

import java.util.List;

import oiasso.system.examples.jpa.datatables.beans.Persona;
public class RestResponsePersonaPage  {

    private int elementOfPage;
    private Long totalElements;
    private int totalPages;
    private int numberOfPage;
	private List<Persona> data;
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
	public List<Persona> getData() {
		return data;
	}
	public void setData(List<Persona> data) {
		this.data = data;
	}


	


//	private List<Map<String, Object>> convert(List<Object> datosLista){
//		
//		List<Map<String, Object>> datosMapa = new ArrayList<Map<String,Object>>();
//		ObjectMapper oMapper = new ObjectMapper();
//		for(Object object : datosLista ) {
//			Map<String, Object> map = oMapper.convertValue(object, Map.class);
//			datosMapa.add(map);
//		}	
//		return datosMapa;
//	}
    
    
}