package com.ohmyapp.scheduler.utils;

import com.ohmyapp.scheduler.config.ScheduleData;
import com.ohmyapp.scheduler.config.ScheduledTaskData;
import com.ohmyapp.scheduler.config.SchedulerData;
import com.ohmyapp.scheduler.config.TaskData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Emerald on 10/1/2016.
 * utils
 */
public class SchedulerUtils {
    private SchedulerUtils() {
        // static class
    }

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
        schedule.setCronString("15 0/1 * * * ? *");
        schedule.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task = new TaskData();
        scheduledTask.setTask(task);
        task.setGroup("group1");
        task.setName("task1");
        task.setTaskParam(new HashMap<>());
        task.setTaskProvider("TaskOne");

        ScheduledTaskData scheduledTask2 = new ScheduledTaskData();
        scheduledTasks.add(scheduledTask2);

        ScheduleData schedule2 = new ScheduleData();
        scheduledTask2.setSchedule(schedule2);
        schedule2.setName("schedule1");
        schedule2.setGroup("group1");
        schedule2.setStartDelay(0);
        schedule2.setCronString("45 0/1 * * * ? *");
        schedule2.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task2 = new TaskData();
        scheduledTask2.setTask(task2);
        task2.setGroup("group2");
        task2.setName("task2");
        task2.setTaskParam(new HashMap<>());
        task2.setTaskProvider("TaskTwo");

        return scheduledTasks;
    }
}
