package oiasso.systems.jacoco.example;

import org.junit.Assert;
import org.junit.Test;

public class ExampleFactoryTest {

	@Test
	public void createString1() {
		ExampleFactory exampleFactory = new ExampleFactory();
		Assert.assertEquals("creating String 1",exampleFactory.createString1());
	}
	
}
