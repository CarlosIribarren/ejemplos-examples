
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (value = Parameterized.class)
public class UtilsTest {

	private Object entrada;
	
	private Integer salida;

	public UtilsTest(Object entrada, Integer salida) {
		super();
		this.entrada = entrada;
		this.salida = salida;
	}

	@Parameters( name = "{index}: toInteger({0})={1}" )
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {  {null, 0},
											{new Integer(1), new Integer(1) }};
			return Arrays.asList(data);
	}

	@Test
	public void testToInteger() {

		Integer resultado = Utils.toInteger(entrada);

		Assert.assertEquals("", salida , resultado);
		
	}
}
