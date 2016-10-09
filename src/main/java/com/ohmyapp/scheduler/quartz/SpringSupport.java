package com.ohmyapp.scheduler.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by Emerald on 9/26/2016.
 * quartz
 */
@Configuration
public class SpringSupport {
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setAutoStartup(false);
        return scheduler;
    }

    @Bean
    @Scope(value = "prototype")
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        if (jobDetailFactoryBean == null ) {
            jobDetailFactoryBean = jobDetailFactoryBean();
        }
        trigger.setJobDetail(jobDetailFactoryBean.getObject());
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

    @Bean
    public SpringJobFactory springJobFactory() {
        return new SpringJobFactory();
    }
}
