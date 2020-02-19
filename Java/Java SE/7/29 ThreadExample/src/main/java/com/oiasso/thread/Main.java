package com.oiasso.thread;

public class Main {

	public static void main(String[] args) {

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		// Lanzar hilo
		MetodoThread metodoThread = new MetodoThread(initialTime);
		metodoThread.start();
		
		System.out.println("Is alive metodo Thread: " + metodoThread.isAlive());
		
		for(int cont = 0 ; cont < 300000 ; cont++) {
			System.out.println(cont);
		}
		
		// Despues de acabar con la ejecucion del metodo run, el hilo se para y se destruye.
		System.out.println("Is alive metodo Thread: " + metodoThread.isAlive());
		
	}

}
