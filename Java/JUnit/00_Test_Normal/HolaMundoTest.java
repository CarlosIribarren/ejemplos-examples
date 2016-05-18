package net.izfe.g210.hgfzergabidea.modelos.modelo048.ejercicio2014.core.beans;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class HolaMundoTest {

	
	
	@Test
	public void testMethod() 
	{
		//Test normal
	}
	
	@Test(timeout=100)
	public void testMethodWithTimeOut() 
	{
		//Test normal con time out.
	}
	
	@Before
	public void methodBefore() 
	{
		//Se ejecuta despues de ejecutar cada test.
	}
	
	@After
	public void methodAfter() 
	{
		//Se ejecuta antes de ejecutar cada test.
	}
	
	
	@BeforeClass
	public static void methodBeforeClass() 
	{
		//Se ejecuta Antes de inicializar la clase
	}
	
	@AfterClass
	public static void methodAfterClass() 
	{
		//Se ejecuta Despues de finalizar la clase
	}
	

	
}
