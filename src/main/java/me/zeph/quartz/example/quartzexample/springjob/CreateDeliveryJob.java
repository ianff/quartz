package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class CreateDeliveryJob extends QuartzJobBean {

  @Autowired
  private CreateDeliveryService createDeliveryService;

  @Override
  protected void executeInternal(JobExecutionContext context) {
    createDeliveryService.createDelivery(context.getFireInstanceId());
  }

}
