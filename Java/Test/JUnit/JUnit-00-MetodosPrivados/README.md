# Testear metodos privados
Para testear un metodo privado, una manera muy sencilla es cambiar la visibilidad del metodo privado por protected. De esta manera se puede acceder al metodo protected desde el mismo paquete, y el test normalmente suele estar en el mismo paquete:

    public class ClaseConMetodoPrivado {

        protected String metodoPrivado() {
            return "Hola mundo desde metodo privado";
        }
    }

Entonces podemos acceder desde la clase de Test (,que esta en el mismo paquete pero en src/java/test,) al metodo sin problemas:

    @Test
    public void metodoPrivadoTest() {
        ClaseConMetodoPrivado claseConMetodoPrivado = new ClaseConMetodoPrivado();
        assertEquals("Hola mundo desde metodo privado", claseConMetodoPrivado.metodoPrivado()); 
    }
