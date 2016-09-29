package com.ohmyapp.scheduler.job;

import org.springframework.stereotype.Service;

/**
 * Created by Emerald on 9/28/2016.
 */
@Service("jobone")
public class JobOne {
    public void myTask(String[] args) {
        System.out.println("This is my task" + args);
    }
}
