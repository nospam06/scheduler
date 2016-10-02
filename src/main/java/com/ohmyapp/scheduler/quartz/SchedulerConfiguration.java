package com.ohmyapp.scheduler.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.PostConstruct;

/**
 * Created by Emerald on 9/26/2016.
 * quartz
 */
@Configuration
public class SchedulerConfiguration {
    static SchedulerConfiguration configuration;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        configuration = this;
    }

    ApplicationContext getContext() {
        return context;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setAutoStartup(false);
        return scheduler;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetailFactoryBean().getObject());
        trigger.setCronExpression("0 0/1 * 1/1 * ? *");
        return trigger;
    }

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setJobClass(ScheduledJob.class);
        jobDetail.setDurability(true);
        return jobDetail;
    }
}
