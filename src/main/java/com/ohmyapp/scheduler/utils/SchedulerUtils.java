package com.ohmyapp.scheduler.utils;

import com.ohmyapp.scheduler.pojo.ScheduleData;
import com.ohmyapp.scheduler.pojo.ScheduledTaskData;
import com.ohmyapp.scheduler.pojo.SchedulerData;
import com.ohmyapp.scheduler.pojo.TaskData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Emerald on 10/1/2016.
 * utils
 */
public class SchedulerUtils {
    public static SchedulerData loadSchedulerConfig() {
        SchedulerData schedulerData = new SchedulerData();
        schedulerData.setId("ohmyapp");
        schedulerData.setName("My Scheduler");
        schedulerData.setThreadCount("10");
        schedulerData.setMissfireThreshold("1000");
        schedulerData.setStartupDelay(0);
        schedulerData.setCluster("true");
        schedulerData.setDsUrl("jdbc:mysql://localhost/test");
        schedulerData.setDsUser("test");
        schedulerData.setDsPassword("test");
        return schedulerData;
    }

    public static List<ScheduledTaskData> loadScheduledTasks() {
        List<ScheduledTaskData> scheduledTasks = new ArrayList<>();
        ScheduledTaskData scheduledTask = new ScheduledTaskData();
        scheduledTasks.add(scheduledTask);

        ScheduleData schedule = new ScheduleData();
        scheduledTask.setSchedule(schedule);
        schedule.setName("schedule1");
        schedule.setGroup("group1");
        schedule.setStartDelay(0);
        schedule.setCronString("0 0/1 * * * ? *");
        schedule.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task = new TaskData();
        scheduledTask.setTask(task);
        task.setGroup("group1");
        task.setName("task1");
        task.setTaskParam(new HashMap<>());
        task.setTaskProvider("TaskOne");

        return scheduledTasks;
    }
}
