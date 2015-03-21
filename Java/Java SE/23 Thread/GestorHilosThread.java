
public class GestorHilosThread extends Thread {

	public GestorHilosThread()
	{
		
	}
	
	public void ejecutarHilosThreadConSleep()
	{
		//ejecutar 2 hilos Thread con sincronized
		Mercado m1 = new Mercado("mercado1");
		Mercado m2 = new Mercado("mercado2");
		m1.start();
		m2.start();
		
		//sirve para que solo entre un hilo en este trozo de codigo
		// de manera unica
		
		synchronized (this) {
			try
			{
				wait(10000);
				System.out.println(Thread.currentThread().getName());
			} 
			catch (InterruptedException e)
			{ 

			}
		}
		System.out.println("test thread acabado");
	}
}
