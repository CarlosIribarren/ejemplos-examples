
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (value = Parameterized.class)
public class UtilsTest {

	private String nombreTest;
	
	private Object entrada;
	
	private Integer salida;

	public UtilsTest(String nombreTest, Object entrada, Integer salida) {
		super();
		this.nombreTest = nombreTest;
		this.entrada = entrada;
		this.salida = salida;
	}

	@Parameters( name = "{index} - {0}: toInteger({1})={2}" )
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {  {"Entrada es null", null, 0},
											{"Entrada es un Integer", new Integer(1), new Integer(1) },
											{"Entrada es un BigDecimal", new BigDecimal(1321), new Integer(1321) }};
			return Arrays.asList(data);
	}

	@Test
	public void testToInteger() {

		Integer resultado = Utils.toInteger(entrada);

		Assert.assertEquals("", salida , resultado);
		
	}
}