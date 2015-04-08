package org.apache.ws.axis2.principal;
import java.rmi.RemoteException;
import org.apache.ws.axis2.FirstWebServiceStub;

// -------------------------- INFO ---------------------------
//
//	Definimos un objeto para recibir especifico
//  Axis sabe como va a ser la respuesta, gracias a que le hemos
//  el wsdl ( descriptor )
//-------------------------------------------------------------


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			//definir un obj para consumir un servicio web
			//obj para consumir el servicio
			FirstWebServiceStub claseParaConsumir = new FirstWebServiceStub();
			//Creamos un servicio web saludar
			FirstWebServiceStub.Saludar saludar = new FirstWebServiceStub.Saludar();
			// Damos el parametro al metodo
			saludar.setNombre("Antonio");
			// Definir una respuesta para el servicio de saludar
			FirstWebServiceStub.SaludarResponse saludarResponse; 
			// recibimos la respuesta del servicio web saludar
			saludarResponse = claseParaConsumir.saludar(saludar);
			// Obtener la respuesta
			String respuestaWebService = saludarResponse.get_return();
			
			System.out.println(respuestaWebService);
			
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
