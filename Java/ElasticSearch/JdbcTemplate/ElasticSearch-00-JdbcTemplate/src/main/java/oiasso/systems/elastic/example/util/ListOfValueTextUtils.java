package oiasso.systems.elastic.example.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import oiasso.systems.elastic.example.model.dto.ValueText;

@Component
public class ListOfValueTextUtils {

	/**
	 * Sort list of ValueText objects. Ordered by the text attribute. 
	 * @param list List of maps
	 * @param keyToOrder Key of map to order
	 */
	public void sortByText(final List<ValueText> list) {
		
		Collections.sort(list, new Comparator<ValueText>() {
		    @Override
			public int compare(final ValueText o1, final ValueText o2) {
		    	
		     	final String o1Text = o1.getText();
		     	final String o2Text = o2.getText();
		    	
		     	 if(o1Text == null){
		     		return 1;
		     	 }
		     	 
		     	 if(o2Text == null){
		     		return -1;
		     	 }		     	 
		     	
	            return o1Text.compareTo(o2Text);
		    }
		});
	
	}
	
}