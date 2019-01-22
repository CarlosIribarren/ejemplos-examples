package com.oiasso.cron;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class ExampleJob implements Job{
	
	/**
	 * Execute the offset Job
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("*********************************************************");
		System.out.println("********************** Hello Quartz! ********************");
		System.out.println("********************** Hello Quartz! ********************");
		System.out.println("********************** Hello Quartz! ********************");
		System.out.println("********************** Hello Quartz! ********************");
		System.out.println("********************** Hello Quartz! ********************");
		System.out.println("*********************************************************");
		
	}
	
	/**
	 * Start the offset Job
	 */
	public static void start() {
		
    	JobDetail job = JobBuilder.newJob(ExampleJob.class)
				.withIdentity("Job1", "JobGroup").build();

    	Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("JobTrigger1", "JobGroup")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0/5 10 * * ?"))
				.build();
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			System.out.println("Error on start");
		}
		
	}

}
