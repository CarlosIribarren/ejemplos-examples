import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
 
public class CustomStepListener implements StepExecutionListener {
 
	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("*************************************************************");
		System.out.println("************* StepExecutionListener - beforeStep ************");
		System.out.println("*************************************************************");
		
		
		
	}
 
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("*************************************************************");
		System.out.println("************* StepExecutionListener - afterStep *************");
		System.out.println("*************************************************************");
		
		
		
		if(stepExecution.getStatus()== BatchStatus.COMPLETED)
		{
			System.out.println("************* StepExecution STATUS :COMPLETED ");
		}
		if(stepExecution.getStatus()== BatchStatus.ABANDONED)
		{
			System.out.println("************* StepExecution STATUS :ABANDONED ");
		}		
		if(stepExecution.getStatus()== BatchStatus.FAILED)
		{
			System.out.println("************* StepExecution STATUS :FAILED");
		}		
		if(stepExecution.getStatus()== BatchStatus.STOPPED)
		{
			System.out.println("************* StepExecution STATUS :STOPPED");
		}
		System.out.println("*************************************************************");
		
		return null;
	}
}
