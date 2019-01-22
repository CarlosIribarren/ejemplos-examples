package com.oiasso.timezone;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class MainTimeZoneOffsetExample {

	/* ********************************************************
	 * *** Ejemplo de obtener Offset en una fecha concreta ****
	 * ********************************************************
	 * 
	 * 	getOffset(date) retorna el offset que corresponde en la fecha que se le pasa, teniendo en cuenta verano/invierno
	 * 
	 */
	
	public static void main(String[] args) {

		
		
		TimeZone timeZoneMadrid = TimeZone.getTimeZone("Europe/Madrid");
		
		// ************* Invierno *******************
		
		// Definir fecha invierno
		Date dateInvierno = new GregorianCalendar(2018, 1, 1).getTime();
		
		// Obtener offset en Milliseconds
		Integer offsetAirportInviernoMilliseconds = timeZoneMadrid.getOffset(dateInvierno.getTime());
		
		// Calcular horas
		long hourasOffsetInvierno = TimeUnit.MILLISECONDS.toHours(offsetAirportInviernoMilliseconds);
		// Calcular minutos
		long minutesOffsetInvierno = TimeUnit.MILLISECONDS.toMinutes(offsetAirportInviernoMilliseconds) - TimeUnit.HOURS.toMinutes(hourasOffsetInvierno);
		// avoid -4:-30 issue
		minutesOffsetInvierno = Math.abs(minutesOffsetInvierno);
		
		System.out.println("Offset Invierno: UTC/GMT " + hourasOffsetInvierno + ":" + minutesOffsetInvierno );
		
		
		// ************* Verano **********************
		
		// Definir fecha verano
		Date dateVerano = new GregorianCalendar(2018, 8, 8).getTime();
		
		// Obtener offset en Milliseconds
		Integer offsetAirportVeranoMilliseconds = timeZoneMadrid.getOffset(dateVerano.getTime());
		
		// Calcular horas
		long hourasOffsetVerano = TimeUnit.MILLISECONDS.toHours(offsetAirportVeranoMilliseconds);
		// Calcular minutos
		long minutesOffsetVerano = TimeUnit.MILLISECONDS.toMinutes(offsetAirportVeranoMilliseconds) - TimeUnit.HOURS.toMinutes(hourasOffsetVerano);
		// avoid -4:-30 issue
		minutesOffsetVerano = Math.abs(minutesOffsetVerano);
		
		System.out.println("Offset Verano: UTC/GMT " + hourasOffsetVerano + ":" + minutesOffsetVerano );
		
	}

}
