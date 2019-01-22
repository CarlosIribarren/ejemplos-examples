package net.izfe.g210.hgfzergabidea.modelos.modelo048.ejercicio2014.core.beans;

public class Calculadora {

	/*
	 * Atributos
	 */
	private Integer numeroUno;
	private Integer numeroDos;

	/*
	 * Constructor
	 */
	public Calculadora(Integer numeroUno, Integer numeroDos) {
		super();
		this.numeroUno = numeroUno;
		this.numeroDos = numeroDos;
	}
	
	/*
	 * Metodo Publico
	 */	
	public Integer calcularSuma()
	{
		return numeroUno + numeroDos;
	}

	
	/*
	 * Getter y Setter
	 */
	public Integer getNumeroUno() {
		return numeroUno;
	}
	public void setNumeroUno(Integer numeroUno) {
		this.numeroUno = numeroUno;
	}
	public Integer getNumeroDos() {
		return numeroDos;
	}
	public void setNumeroDos(Integer numeroDos) {
		this.numeroDos = numeroDos;
	}

}
