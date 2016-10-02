package com.ohmyapp.scheduler.api;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Emerald on 10/1/2016.
 * scheduled task
 */
public interface Task {
    /**
     * execute task with parm
     * @param parm  parameter
     */
    void execute(Map<String, Object> parm);
}
