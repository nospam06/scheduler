package com.ohmyapp.scheduler.pojo;

/**
 * Created by Emerald on 10/1/2016.
 * scheduled task
 */
public class ScheduledTaskData {
    private ScheduleData schedule;
    private TaskData task;

    public ScheduleData getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleData schedule) {
        this.schedule = schedule;
    }

    public TaskData getTask() {
        return task;
    }

    public void setTask(TaskData task) {
        this.task = task;
    }
}
