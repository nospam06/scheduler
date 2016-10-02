package com.ohmyapp.scheduler.quartz;

import com.ohmyapp.scheduler.config.ScheduleData;
import com.ohmyapp.scheduler.config.ScheduledTaskData;
import com.ohmyapp.scheduler.config.SchedulerData;
import com.ohmyapp.scheduler.config.TaskData;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Emerald on 10/1/2016.
 * scheduler
 */
@Component
public class Scheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    private SpringSupport springSupport;

    private SchedulerFactoryBean scheduler;

    public void startScheduler(SchedulerData schedulerData) {
        scheduler = springSupport.schedulerFactoryBean();
        scheduler.setOverwriteExistingJobs(true);
        scheduler.setStartupDelay(schedulerData.getStartupDelay());
        scheduler.setJobFactory(new SpringBeanJobFactory());
        scheduler.setDataSource(dataSource(schedulerData.getDsUrl(), schedulerData.getDsUser(),
                schedulerData.getDsPassword()));

        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceId", schedulerData.getId());
        quartzProperties.setProperty("org.quartz.scheduler.instanceName", schedulerData.getName());
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", schedulerData.getThreadCount());
        quartzProperties.setProperty("org.quartz.jobStore.misfireThreshold", schedulerData.getMissfireThreshold());
        quartzProperties.setProperty("org.quartz.jobStore.isClustered", schedulerData.getCluster());
        scheduler.setQuartzProperties(quartzProperties);

    }

    public void setTasks(List<ScheduledTaskData> taskList) {
        Trigger[] triggers = new Trigger[taskList.size()];
        int count = 0;
        for (ScheduledTaskData scheduledTask : taskList) {
            JobDetailFactoryBean jobDetail = springSupport.jobDetailFactoryBean();
            TaskData taskData = scheduledTask.getTask();
            jobDetail.setName(taskData.getName());
            jobDetail.setGroup(taskData.getGroup());
            jobDetail.setDescription(taskData.getTaskProvider());
            jobDetail.setDurability(true);
            jobDetail.setJobClass(ScheduledJob.class);
            Map<String, Object> taskParam = taskData.getTaskParam();
            jobDetail.setJobDataAsMap(taskParam);
            jobDetail.afterPropertiesSet();

            CronTriggerFactoryBean trigger = springSupport.cronTriggerFactoryBean();
            ScheduleData schedule = scheduledTask.getSchedule();
            trigger.setName(schedule.getName());
            trigger.setGroup(schedule.getGroup());
            trigger.setDescription(schedule.getDescription());
            trigger.setMisfireInstructionName(schedule.getMisfireInstruction());
            trigger.setCronExpression(schedule.getCronString());
            trigger.setStartDelay(schedule.getStartDelay());
            trigger.setJobDetail(jobDetail.getObject());
            try {
                trigger.afterPropertiesSet();
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
            triggers[count++] = trigger.getObject();
        }
        scheduler.setTriggers(triggers);
        try {
            scheduler.afterPropertiesSet();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        scheduler.start();
    }

    public void shutdown() {
        try {
            scheduler.stop();
            scheduler.destroy();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private DataSource dataSource(String url, String user, String password) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }
}
