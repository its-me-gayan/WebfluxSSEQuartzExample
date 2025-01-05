package com.example.webfluxssequartzexample.job;


import com.example.webfluxssequartzexample.service.JobService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/4/25
 * Time: 11:07 PM
 */
@Component
public class LongRunningJob implements Job {

    @Autowired
    private  JobService jobService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int jobId = Integer.parseInt(jobExecutionContext.getJobDetail().getKey().getName());
        try {
            for (double i = 1; i <= 100; i++) {
                // Simulate work
                Thread.sleep(2000);

                // Update progress
                jobService.updateJobProgress(jobId, i);
            }
            jobService.updateJobProgress(jobId, 100.0);
        } catch (Exception e) {
            jobService.updateJobProgress(jobId, 0.0);
        }
    }
}
