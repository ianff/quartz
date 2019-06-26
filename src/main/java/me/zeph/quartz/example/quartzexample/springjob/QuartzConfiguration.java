package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
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
  public SchedulerFactoryBean scheduler(JobDetail jobDetail, Trigger trigger) {
    SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
    schedulerFactoryBean.setJobFactory(springBeanJobFactory());
    schedulerFactoryBean.setJobDetails(jobDetail);
    schedulerFactoryBean.setTriggers(trigger);
    return schedulerFactoryBean;
  }

  @Bean
  public SimpleTriggerFactoryBean trigger(JobDetail jobDetail){
    SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
    simpleTriggerFactoryBean.setJobDetail(jobDetail);
    simpleTriggerFactoryBean.setRepeatInterval(30000);
    simpleTriggerFactoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    return simpleTriggerFactoryBean;
  }

}
