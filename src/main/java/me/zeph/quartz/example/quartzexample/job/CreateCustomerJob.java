package me.zeph.quartz.example.quartzexample.job;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class CreateCustomerJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext context) {
    System.out.println("customer created " + context.getFireInstanceId() + " at " + new Date().toString());
  }
}
