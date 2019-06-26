package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class QuartzConfiguration {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public SpringBeanJobFactory springBeanJobFactory() {
    SpringBeanJobFactory springBeanJobFactory = new SpringBeanJobFactory();
    springBeanJobFactory.setApplicationContext(applicationContext);
    return springBeanJobFactory;
  }

  @Bean
  public JobDetailFactoryBean jobDetail() {
    JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
    jobDetailFactoryBean.setJobClass(CreateDeliveryJob.class);
    jobDetailFactoryBean.setDurability(true);
    return jobDetailFactoryBean;
  }

  @Bean
  public SchedulerFactoryBean scheduler() {
    SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
    schedulerFactoryBean.setJobFactory(springBeanJobFactory());
    schedulerFactoryBean.setJobDetails(jobDetail().getObject());
    schedulerFactoryBean.setTriggers(trigger().getObject());
    return schedulerFactoryBean;
  }

  @Bean
  public SimpleTriggerFactoryBean trigger(){
    SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
    simpleTriggerFactoryBean.setJobDetail(jobDetail().getObject());
    simpleTriggerFactoryBean.setRepeatInterval(300000);
    simpleTriggerFactoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    return simpleTriggerFactoryBean;
  }

}
