package oiasso.systems.example.cronjobsdinamically;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService{

	
	// Task Scheduler
	private TaskScheduler scheduler;
	
	// A map for keeping scheduled tasks
	private Map<Integer, ScheduledFuture<?>> jobsMap = new HashMap<>();
	
	@Autowired
	public ScheduleTaskServiceImpl(TaskScheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	
	// Schedule Task to be executed
	public void addTaskToScheduler(int id, Runnable task, CronTrigger cronTrigger) {
		ScheduledFuture<?> scheduledTask = scheduler.schedule(task, cronTrigger);
		jobsMap.put(id, scheduledTask);
	}
	
	// Remove scheduled task 
	public void removeTaskFromScheduler(int id) {
		ScheduledFuture<?> scheduledTask = jobsMap.get(id);
		if(scheduledTask != null) {
			scheduledTask.cancel(true);
			jobsMap.put(id, null);
		}
	}
	
	// A context refresh event listener
	@EventListener({ ContextRefreshedEvent.class })
	public void contextRefreshedEvent() {
		// Get all tasks from DB and reschedule them in case of context restarted

		System.out.println("*** ContextRefreshedEvent ***");

	}
}
