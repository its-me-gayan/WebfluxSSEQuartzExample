package com.example.webfluxssequartzexample.service;


import com.example.webfluxssequartzexample.model.JobRespModel;
import org.quartz.SchedulerException;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/5/25
 * Time: 8:55 PM
 */
public interface JobSchedulerService {
    JobRespModel triggerJob() throws SchedulerException;
}
