package me.zeph.quartz.example.quartzexample.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerJob extends QuartzJobBean {
  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

  }
}
