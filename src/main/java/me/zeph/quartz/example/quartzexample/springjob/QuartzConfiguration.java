package me.zeph.quartz.example.quartzexample.springjob;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
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
    jobDetailFactoryBean.setJobClass(SendMessageJob.class);
    jobDetailFactoryBean.setDurability(true);
    return jobDetailFactoryBean;
  }

  @Bean
  public SchedulerFactoryBean scheduler(JobDetail jobDetail, Trigger trigger) {
    SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
    schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
    schedulerFactoryBean.setJobFactory(springBeanJobFactory());
    schedulerFactoryBean.setJobDetails(jobDetail);
    schedulerFactoryBean.setTriggers(trigger);
    return schedulerFactoryBean;
  }

  @Bean
  public CronTriggerFactoryBean trigger(JobDetail jobDetail) {
    CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
    cronTriggerFactoryBean.setJobDetail(jobDetail);
    cronTriggerFactoryBean.setCronExpression("0 0,5,10,15,20,25,30,35,40,45,50,55 * * * ?");
    return cronTriggerFactoryBean;
  }

}
