package oiasso.systems.example.cronjobsdinamically;

import org.springframework.scheduling.support.CronTrigger;

public interface ScheduleTaskService {
    
    public void addTaskToScheduler(int id, Runnable task, CronTrigger cronTrigger);

    public void removeTaskFromScheduler(int id);

    public void contextRefreshedEvent();
}
