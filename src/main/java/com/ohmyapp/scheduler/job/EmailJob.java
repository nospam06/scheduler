package com.ohmyapp.scheduler.job;

import com.ohmyapp.scheduler.service.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Emerald on 9/27/2016.
 * job
 */
public class EmailJob implements Job {
    @Autowired
    private EmailService cronService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        cronService.sendSpam();
    }
}