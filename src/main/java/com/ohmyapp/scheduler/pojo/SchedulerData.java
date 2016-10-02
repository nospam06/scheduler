package com.ohmyapp.scheduler.pojo;

/**
 * Created by Emerald on 10/1/2016.
 * schedule
 */
public class SchedulerData {
    private String id;
    private String name;
    private String threadCount;
    private String missfireThreshold;
    private String cluster;
    private int startupDelay;
    private String dsUrl;
    private String dsUser;
    private String dsPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(String threadCount) {
        this.threadCount = threadCount;
    }


    public String getMissfireThreshold() {
        return missfireThreshold;
    }

    public void setMissfireThreshold(String missfireThreshold) {
        this.missfireThreshold = missfireThreshold;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public int getStartupDelay() {
        return startupDelay;
    }

    public void setStartupDelay(int startupDelay) {
        this.startupDelay = startupDelay;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getDsUser() {
        return dsUser;
    }

    public void setDsUser(String dsUser) {
        this.dsUser = dsUser;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }
}
