package com.example.webfluxssequartzexample.service.Impl;


import com.example.webfluxssequartzexample.job.LongRunningJob;
import com.example.webfluxssequartzexample.model.JobRespModel;
import com.example.webfluxssequartzexample.service.JobSchedulerService;
import com.example.webfluxssequartzexample.service.JobService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/5/25
 * Time: 8:55 PM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class JobSchedulerServiceImpl implements JobSchedulerService {

    private final JobService jobService;
    private final Scheduler scheduler;

    @Override
    public JobRespModel triggerJob() throws SchedulerException {
        int jobId = 1 + (int) (Math.random() * 100);
        JobDetail jobDetail = JobBuilder.newJob(LongRunningJob.class)
                .usingJobData("jobId" , jobId)
                .usingJobData("jobsGroup" , "my")
                .withIdentity(String.valueOf(jobId))
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobId+ "Trigger")
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        return JobRespModel.builder()
                .id(jobId)
                .jobName("my-job-".concat(String.valueOf(jobId)))
                .jobProgress(0.0)
                .jobStatus("IN-PROGRESS")
                .build();
    }
}
