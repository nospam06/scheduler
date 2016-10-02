package com.ohmyapp.scheduler.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emerald on 10/1/2016.
 * data
 */
public class TaskData {
    private String name;
    private String group;
    private String taskProvider;
    private Map<String, Object> taskParam = new HashMap<>();

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

    public String getTaskProvider() {
        return taskProvider;
    }

    public void setTaskProvider(String taskProvider) {
        this.taskProvider = taskProvider;
    }

    public Map<String, Object> getTaskParam() {
        return new HashMap<>(taskParam);
    }

    public void setTaskParam(Map<String, Object> taskParam) {
        this.taskParam.clear();
        this.taskParam.putAll(taskParam);
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