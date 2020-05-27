package oiasso.systems.elastic.example.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import oiasso.systems.elastic.example.model.dto.ValueText;

public class ListOfMapUtilsTest {

	private static final String VALUE_SPOT_ID_1 = "163";
	private static final String VALUE_SPOT_NAME_1 = "Audi";
	
	private static final String VALUE_SPOT_ID_2 = "542";
	private static final String VALUE_SPOT_NAME_2 = "HP";

	private static final String VALUE_SPOT_ID_3 = "215";
	private static final String VALUE_SPOT_NAME_3 = "Nike";
	
	
	private ListOfValueTextUtils listOfValueTextUtils;
	
	@Before
	public void setUp() {
		listOfValueTextUtils = new ListOfValueTextUtils();
	}
	
	@Test
	public void sortByText_when_objects_of_list_have_value_and_text_should_return_orded_list_by_text() {
		final List<ValueText> list = createListOsMapValues();

		listOfValueTextUtils.sortByText(list);

		assertEquals(VALUE_SPOT_ID_1, list.get(0).getValue());
		assertEquals(VALUE_SPOT_NAME_1, list.get(0).getText());
		assertEquals(VALUE_SPOT_ID_2, list.get(1).getValue());
		assertEquals(VALUE_SPOT_NAME_2, list.get(1).getText());
		assertEquals(VALUE_SPOT_ID_3, list.get(2).getValue());
		assertEquals(VALUE_SPOT_NAME_3, list.get(2).getText());
	}
	
	@Test
	public void sortByText_when_one_object_of_list_have_text_null_should_return_orded_list_by_text_and_object_with_text_null_are_last() {
		final List<ValueText> list = createListOsMapValues();
		list.get(1).setText(null);
		list.add(new ValueText(VALUE_SPOT_ID_2, VALUE_SPOT_NAME_2));
		
		listOfValueTextUtils.sortByText(list);

		assertEquals(VALUE_SPOT_ID_2, list.get(0).getValue());
		assertEquals(VALUE_SPOT_NAME_2, list.get(0).getText());	
		assertEquals(VALUE_SPOT_ID_2, list.get(1).getValue());
		assertEquals(VALUE_SPOT_NAME_2, list.get(1).getText());
		assertEquals(VALUE_SPOT_ID_3, list.get(2).getValue());
		assertEquals(VALUE_SPOT_NAME_3, list.get(2).getText());
		assertEquals(VALUE_SPOT_ID_1, list.get(3).getValue());
		assertNull(VALUE_SPOT_NAME_1, list.get(3).getText());		
		
	}
	
	private List<ValueText> createListOsMapValues(){
		final List<ValueText> list = new ArrayList<>();
		list.add(new ValueText(VALUE_SPOT_ID_2, VALUE_SPOT_NAME_2));
		list.add(new ValueText(VALUE_SPOT_ID_1, VALUE_SPOT_NAME_1));
		list.add(new ValueText(VALUE_SPOT_ID_3, VALUE_SPOT_NAME_3));
		return list;
	}
}
