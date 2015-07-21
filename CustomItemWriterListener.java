import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.core.ItemWriteListener;
 
public class CustomItemWriterListener implements ItemWriteListener<Bean1> {
 
	@Override
	public void beforeWrite(List<? extends Bean1> items) {
		System.out.println("ItemWriteListener - beforeWrite");
	}
 
	@Override
	public void afterWrite(List<? extends Bean1> items) {
		
		System.out.println("************ LISTA DE RESULTADOS TRATADOS *************");
		
		for(Bean1 bean : items )
		{
			System.out.println("Bean1 : " + bean.getfAM_NOMCAS());
		}
		
		System.out.println("********************************************************");
		
		System.out.println("ItemWriteListener - afterWrite");
	}
 
	@Override
	public void onWriteError(Exception exception, List<? extends Bean1> items) {
		System.out.println("ItemWriteListener - onWriteError");
	}
 
}
