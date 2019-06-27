package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class SendMessageJob extends QuartzJobBean {

  @Autowired
  private MessageService messageService;

  @Override
  protected void executeInternal(JobExecutionContext context) {
    messageService.send(context.getFireInstanceId());
  }

}
