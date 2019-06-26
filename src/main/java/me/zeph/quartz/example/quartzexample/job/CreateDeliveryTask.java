package me.zeph.quartz.example.quartzexample.job;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
public class CreateDeliveryTask implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // Grab the Scheduler instance from the Factory
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

    // and start it off
    scheduler.start();

    // define the job and tie it to our HelloJob class
    JobDetail job = newJob(CreateDeliveryJob.class)
        .withIdentity("job1", "group1")
        .build();

    // Trigger the job to run now, and then repeat every 40 seconds
    Trigger trigger = newTrigger()
        .withIdentity("trigger1", "group1")
        .startNow()
        .withSchedule(simpleSchedule()
            .withIntervalInSeconds(30)
            .repeatForever())
        .build();

    // Tell quartz to schedule the job using our trigger
    scheduler.scheduleJob(job, trigger);
//    scheduler.shutdown();
  }
}
