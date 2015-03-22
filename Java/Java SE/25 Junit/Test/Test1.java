import static org.junit.Assert.*;

import org.junit.Test;

//test 1 : CORRECTO
//test 2 : ERROR => la lista LinkedList no esta inicializada


// ------- Anotaciones para JUnit ------------------
// @Before : Los metodos que tengan la anotacion de @Before 
// se ejecuta antes que los metodos que tengan anotaciones @Test

// @BeforeClass, Los metodos que tengan la anotacion de @Before 
//se ejecuta antes que los metodos que tengan anotaciones @Test
//	+ y ademas ejecuta el metodo antes de todo.

// @After Los metodos que tengan la anotacion de @Before 
//se ejecuta despues que los metodos que tengan anotaciones @Test

// @AfterClass
// @Test ( parametros )

public class Test1 {

	@Test
	public void probarCreacionDeObjeto() {
		
		//definimos un obj Persona
		Persona p = new Persona("Juan");
		//probamos a ver si el Objeto Persona es null
		//El Objeto persona no es null porque se ha creado correctamente
		assertNotNull(p);

	}
	
	@Test
	public void probarCreacionDeObjetoLista() {
		
		//definimos un obj Persona
		Persona p = new Persona("Juan");
		
		//si preguntamos por el objeto p.getCoches(), da ERROR, porque el 
		//LinkedList no esta inicializado. ( para que no diera error se podria inicializar 
		//cuando se define el la clase propietaria.
		assertNotNull(p.getCoches());

	}
}
