public class GestorBD {
    private static GestorBD INSTANCE = null;
 
    // El constructor privado no permite que se genere un constructor por defecto
    private GestorBD() {}
 
    // Crear la instancia debe ser sincronizado (o sincronizar el código dentro)
    // para protegerse de posibles problemas  multi-hilo
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new GestorBD();
        }
    }
 
    public static GestorBD getInstance() {
        createInstance();
        return INSTANCE;
    }
    
    @Override
    // El método "clone" debe ser sobreescrito para evitar duplicación de objetos
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
    
    public void añadirOBJ()
    {
    	
    }
}