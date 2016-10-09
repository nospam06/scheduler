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
        schedule2.setName("schedule2");
        schedule2.setGroup("group1");
        schedule2.setStartDelay(0);
        schedule2.setCronString("45 0/1 * * * ? *");
        schedule2.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task2 = new TaskData();
        scheduledTask2.setTask(task2);
        task2.setGroup("group1");
        task2.setName("task2");
        task2.setTaskParam(new HashMap<>());
        task2.setTaskProvider("TaskTwo");

        ScheduledTaskData scheduledTask3 = new ScheduledTaskData();
        scheduledTasks.add(scheduledTask3);

        ScheduleData schedule3 = new ScheduleData();
        scheduledTask3.setSchedule(schedule3);
        schedule3.setName("schedule1");
        schedule3.setGroup("group2");
        schedule3.setStartDelay(0);
        schedule3.setCronString("35 0/1 * * * ? *");
        schedule3.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task3 = new TaskData();
        scheduledTask3.setTask(task3);
        task3.setGroup("group2");
        task3.setName("task1");
        task3.setTaskParam(new HashMap<>());
        task3.setTaskProvider("TaskOne");

        ScheduledTaskData scheduledTask4 = new ScheduledTaskData();
        scheduledTasks.add(scheduledTask4);

        ScheduleData schedule4 = new ScheduleData();
        scheduledTask4.setSchedule(schedule4);
        schedule4.setName("schedule2");
        schedule4.setGroup("group2");
        schedule4.setStartDelay(0);
        schedule4.setCronString("5 0/1 * * * ? *");
        schedule4.setMisfireInstruction("MISFIRE_INSTRUCTION_SMART_POLICY");

        TaskData task4 = new TaskData();
        scheduledTask4.setTask(task4);
        task4.setGroup("group2");
        task4.setName("task2");
        task4.setTaskParam(new HashMap<>());
        task4.setTaskProvider("TaskTwo");

        return scheduledTasks;
    }
}
