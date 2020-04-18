package oiasso.system.examples.junit.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ClaseConMetodoPrivadoTest
 */
public class ClaseConMetodoPrivadoTest {

    @Test
    public void metodoPrivadoTest() {
        ClaseConMetodoPrivado claseConMetodoPrivado = new ClaseConMetodoPrivado();
        assertEquals("Hola mundo desde metodo privado", claseConMetodoPrivado.metodoPrivado()); 
    }
}