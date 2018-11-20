
import java.math.BigDecimal;

public class Utils {

	/**
	 * Convert to Integer.
	 * 
	 * @param o Object to convert to Integer
	 * @return Integer number
	 */
	public static Integer toInteger(Object o) {
		Integer val = 0;
		 if(Integer.class.isInstance(o)) {
			 val = (Integer) o;
		 } else if(BigDecimal.class.isInstance(o)) {
			 BigDecimal bigD = (BigDecimal) o;
			 val = Integer.valueOf(bigD.toString());
		 }
		 return val;
	}
	
}
