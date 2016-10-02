package com.ohmyapp.scheduler;

import com.ohmyapp.scheduler.pojo.ScheduledTaskData;
import com.ohmyapp.scheduler.pojo.SchedulerData;
import com.ohmyapp.scheduler.quartz.Scheduler;
import com.ohmyapp.scheduler.utils.SchedulerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Emerald on 10/1/2016.
 * bootstrap
 */
@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        SchedulerData schedulerData = SchedulerUtils.loadSchedulerConfig();
        List<ScheduledTaskData> scheduledTaskList = SchedulerUtils.loadScheduledTasks();

        scheduler.startScheduler(schedulerData);
        scheduler.setTasks(scheduledTaskList);
    }

    @PreDestroy
    public void shutdown() {
        scheduler.shutdown();
    }
}
