package com.ohmyapp.scheduler.config;

/**
 * Created by Emerald on 10/1/2016.
 * schedule
 */
public class ScheduleData {
    private String name;
    private String group;
    private String description;
    private String cronString;
    private String misfireInstruction;
    private long startDelay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCronString() {
        return cronString;
    }

    public void setCronString(String cronString) {
        this.cronString = cronString;
    }

    public String getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(String misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public long getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(long startDelay) {
        this.startDelay = startDelay;
    }

    @Override
    public int hashCode() {
        return (group + name).hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) {
            return true;
        }
        if (getClass().equals(other.getClass())) {
            TaskData otherTask = (TaskData) other;
            if (getGroup().equals(otherTask.getGroup()) && getName().equals(otherTask.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getGroup() + '.' + getName();
    }
}
