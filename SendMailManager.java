package es.lacaixa.absis.batch.app.ccfccf.util;

import java.util.Vector;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SendMailManager implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)throws Exception {
		
		STDEmailUtils stdEmailUtils = new STDEmailUtils();
		
		String destino = new String("carlos.iribarren@hp.com");
		String origen = new String("carlos.iribarren@hp.com");
		String copia = new String("carlos.iribarren@hp.com");
		String oculto = new String("carlos.iribarren@hp.com");
		String asunto = new String("email joseba");
		String texto = new String("hola");
		String directorio = new String("files/");
		Vector<String> contenido = new Vector<String>(); 
		contenido.add("infJobAoe.properties");
		
		
		
		stdEmailUtils.enviaEmailGenerico(destino, origen, copia, oculto, asunto, texto, directorio, contenido);
		
		return RepeatStatus.FINISHED;
	}

}
