package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateDeliveryJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext context) {
    System.out.println("delivery created " + context.getFireInstanceId() + " at " + new Date().toString());

  }

}
