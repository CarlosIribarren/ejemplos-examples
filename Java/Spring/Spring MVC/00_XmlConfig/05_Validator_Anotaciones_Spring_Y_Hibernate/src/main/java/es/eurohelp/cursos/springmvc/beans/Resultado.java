package es.eurohelp.cursos.springmvc.beans;

import org.hibernate.validator.constraints.Range;


public class Resultado {

	
	@Range(min=0,max=100)
	private Double a;

	public Resultado() {
		a=100.0;
	}
	
	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

}
