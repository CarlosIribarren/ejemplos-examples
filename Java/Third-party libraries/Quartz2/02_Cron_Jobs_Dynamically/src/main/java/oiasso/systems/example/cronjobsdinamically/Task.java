package oiasso.systems.example.cronjobsdinamically;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task implements Runnable {
    
    private String name;

    public Task(String name){
        this.name = name;
    }

    public void run() {

            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            System.out.println( time.format(formatter) + " - Task: " + name );
      }

}
