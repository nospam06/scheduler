package com.ohmyapp.scheduler.task;

import com.ohmyapp.scheduler.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Emerald on 10/1/2016.
 * task one
 */
@Component("TaskTwo")
public class TaskTwo implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTwo.class);

    @Override
    public void execute(Map<String, Serializable> parm) {
        Serializable jobKey = parm.get("key");
        LOGGER.info("{} {}", new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS").format(new Date()),
                jobKey);
    }
}
