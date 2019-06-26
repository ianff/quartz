package me.zeph.quartz.example.quartzexample.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class CreateCustomerJob implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.out.println("customer created " + context.getFireInstanceId() + " at " + new Date().toString());
  }
}
