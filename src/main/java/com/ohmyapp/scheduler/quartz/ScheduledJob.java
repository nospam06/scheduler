package com.ohmyapp.scheduler.quartz;

import com.ohmyapp.scheduler.api.Task;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.HashMap;

/**
 * Created by Emerald on 10/1/2016.
 * job
 */
@DisallowConcurrentExecution
public class ScheduledJob extends QuartzJobBean {
     @Override
    protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
        JobDataMap dataMap = jobContext.getJobDetail().getJobDataMap();
        String task = jobContext.getJobDetail().getDescription();
        HashMap<String, Object> parmMap = new HashMap<>(dataMap);
        ApplicationContext context = SpringSupport.springSupport.getContext();
        Task taskBean = context.getBean(task, Task.class);

        parmMap.put("key", jobContext.getJobDetail().getKey().toString());
        taskBean.execute(parmMap);
    }
}
