package oiasso.systems.junit.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.junit.Assert;
import org.junit.Test;

public class PropertyUtilsTest {

	@Test
	public void getHttpHostListTest() {
		
		// Preparar resultado
		List<HttpHost> excepted = new ArrayList<>();
		excepted.add(new HttpHost("localhost", 9200, "http"));
		excepted.add(new HttpHost("192.168.24.62", 9201, "https"));
		
		// Probar
		List<String> urls = new ArrayList<>();
		urls.add("http://localhost:9200");
		urls.add("https://192.168.24.62:9201");
		List<HttpHost> actual = PropertyUtils.getHttpHostList(urls);
		
		// Verificar
		Assert.assertEquals(excepted, actual);
	}
	
	
	@Test
	public void getHttpHostListNull() {
		
		// Preparar resultado
		List<HttpHost> excepted = new ArrayList<>();
		
		// Propar
		List<String> urls = null;
		List<HttpHost> actual = PropertyUtils.getHttpHostList(urls);
		
		// Verificar
		Assert.assertEquals(excepted, actual);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void getHttpHostListIllegalArgumentException() {
		
		// Preparar resultado
		List<HttpHost> excepted = new ArrayList<>();
		excepted.add(new HttpHost("localhost", 9200, "http"));
		
		// Propar
		List<String> urls = new ArrayList<>();
		urls.add("http://localhost");
		PropertyUtils.getHttpHostList(urls);
		
	}
	
	
	
	/**************************************************
	 * Como es una clase con metodos estaticos. Si miramos la covertura no se obtiene el 100%.
	 * En una clase normal en la que se crea una instancia para el test, si se obtiene el 100%.
	 * Las clases con metodos estaticos, normalmente, no se inctancian por lo que no podemos probar el constructor,...
	 * No pasa nada por no tener el 100% de cobertura.
	 * 
	 * Si queremos que nadie pueda instanciar la clase y testear la creacion de la clase tambien, 
	 * para que asi nos de una cobertura del 100%. Entonces creamos el metodo privado en la clase,
	 * que arroja una excepcion y luego testeamos ese metodo, asi conseguimos el objetivo de asegurarnos 
	 * que nadie puede instanciar la clase y que obtenemos el 100% de la cobertura.
	 */
	

	
	
}
