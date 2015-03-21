public class Mercado extends Thread {
	
	public Mercado (String threadName) {
		super(threadName); // nombre del hilo
	}
	
	public void run() {
		System.out.println("Estamos en la clase mercado");
	}
}