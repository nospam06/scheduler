package com.ohmyapp.scheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Emerald on 9/27/2016.
 * service
 */
@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void sendSpam() {

        LOGGER.info("Should send emails");
    }

}