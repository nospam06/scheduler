package com.ohmyapp.scheduler.config;

import com.ohmyapp.scheduler.job.JobTwo;
import org.quartz.CronTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Emerald on 9/26/2016.
 * quartz
 */
@Configuration
public class QuartzConfiguration {

    @Value("${org.quartz.scheduler.instanceName}")
    private String instanceName;

    @Value("${org.quartz.scheduler.instanceId}")
    private String instanceId;

    @Value("${org.quartz.threadPool.threadCount}")
    private String threadCount;

    @Value("${job.startDelay}")
    private Long startDelay;

    @Value("${job.repeatInterval}")
    private Long repeatInterval;

    @Value("${job.description}")
    private String description;

    @Value("${job.key}")
    private String key;

    @Autowired
    private DataSource dataSource;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(new SpringBeanJobFactory());
        factory.setDataSource(dataSource);
        factory.setTriggers(cronTriggerFactoryBean().getObject());

        Properties quartzProperties = new Properties();
        quartzProperties.setProperty(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, instanceName);
        quartzProperties.setProperty(StdSchedulerFactory.PROP_SCHED_INSTANCE_ID, instanceId);
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", threadCount);
        quartzProperties.setProperty("org.quartz.jobStore.misfireThreshold", "1000");
        quartzProperties.setProperty("org.quartz.jobStore.isClustered", "true");
        factory.setQuartzProperties(quartzProperties);

        return factory;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(jobDetailFactoryBean().getObject());
        cronTrigger.setStartDelay(1000);
        cronTrigger.setName("mytrigger");
        cronTrigger.setGroup("mygroup");
        cronTrigger.setCronExpression("0 0/1 * 1/1 * ? *");
        cronTrigger.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_SMART_POLICY);
        return cronTrigger;
    }

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(JobTwo.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name", "RAM");
        map.put(JobTwo.COUNT, 1);
        factory.setJobDataAsMap(map);
        factory.setGroup("mygroup");
        factory.setName("myjob");
        factory.setDurability(true);
        return factory;
    }
}
