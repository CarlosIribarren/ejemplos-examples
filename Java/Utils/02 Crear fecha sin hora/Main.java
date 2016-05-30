import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		// ***** Crear objeto fecha sin hora *************
		// Get Calendar object set to the date and time of the given Date object
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		 
		// Set time fields to zero
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		 
		// Put it back in the Date object
		Date fechaSinHora = cal.getTime();
	
		
	}
}
