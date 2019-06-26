package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerJob extends QuartzJobBean {

  @Autowired
  private CreateCustomerService createCustomerService;

  @Override
  protected void executeInternal(JobExecutionContext context) {
    createCustomerService.createDelivery(context.getFireInstanceId());
  }

}
