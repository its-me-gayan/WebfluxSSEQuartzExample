package com.example.webfluxssequartzexample.controller;


import com.example.webfluxssequartzexample.model.JobRespModel;
import com.example.webfluxssequartzexample.service.JobSchedulerService;
import com.example.webfluxssequartzexample.service.JobService;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/4/25
 * Time: 11:04 PM
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuartzJobController {

    private final JobService jobService;
    private final JobSchedulerService jobSchedulerService;

    @GetMapping("/api/v1/job/create")
    ResponseEntity<JobRespModel> createAndGetQuartzJob() throws SchedulerException {
        return ResponseEntity.ok(jobSchedulerService.triggerJob());
    }

    @GetMapping("/api/v1/job/{id}/progress")
    Flux<ServerSentEvent<JobRespModel>> getJobProgress(@PathVariable("id") Integer id) {
        return jobService.getProgress(id);
    }

}
