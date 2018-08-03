package com.oiasso.thread;


public class MetodoThread extends Thread {

	private long initialTime;
	
	public MetodoThread(long initialTime) {
		this.initialTime = initialTime;
	}

	@Override
	public void run() {
		System.out.println("INICIO TIEMPO: " + ( System.currentTimeMillis() - this.initialTime ) / 1000  + "seg");
		this.esperarXsegundos(2);
		// Despues de 10 segundos, actualiza la BD
		System.out.println("Actualizada la BD");
		System.out.println("FIN TIEMPO: " + ( System.currentTimeMillis()  - this.initialTime ) / 1000  + "seg");
	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}