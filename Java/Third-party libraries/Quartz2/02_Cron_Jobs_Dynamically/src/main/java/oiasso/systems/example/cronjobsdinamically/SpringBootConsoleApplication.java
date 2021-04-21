package oiasso.systems.example.cronjobsdinamically;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	private ScheduleTaskService scheduleTaskService;

    @Override
    public void run(String... args) {
        
 
		// Add Task 1 to execute every 10 seconds
		scheduleTaskService.addTaskToScheduler(1, new Task("1"), new CronTrigger("0/10 * * * * ?", TimeZone.getTimeZone(TimeZone.getDefault().getID())));

		// Add Task 2 to execute every 5 seconds
		scheduleTaskService.addTaskToScheduler(2, new Task("2"), new CronTrigger("0/5 * * * * ?", TimeZone.getTimeZone(TimeZone.getDefault().getID())));
		

		// Sleep 30 seconds
		try
		{
			Thread.sleep(30000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}

		// Remove Task 1
		scheduleTaskService.removeTaskFromScheduler(1);


    }

}
