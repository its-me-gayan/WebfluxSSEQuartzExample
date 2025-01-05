package com.example.webfluxssequartzexample.service.Impl;


import com.example.webfluxssequartzexample.model.JobRespModel;
import com.example.webfluxssequartzexample.service.JobService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/4/25
 * Time: 11:51 PM
 */
@Service
public class JobServiceImpl implements JobService {
    private final Map<Integer, Sinks.Many<JobRespModel>> progressSinks = new ConcurrentHashMap<>();

    @Override
    public void updateJobProgress(Integer jobId, Double progress) {
        Sinks.Many<JobRespModel> sink = progressSinks.computeIfAbsent(jobId, id -> Sinks.many().multicast().onBackpressureBuffer());
        sink.tryEmitNext(JobRespModel.builder().id(jobId).jobStatus("IN-PROGRESS").jobProgress(progress).build());
        if (progress == 100) {
            sink.tryEmitComplete();
            progressSinks.remove(jobId);
        }
    }

    public Flux<ServerSentEvent<JobRespModel>> getProgress(Integer jobId) {
        // Check if the jobId exists in the map
        Sinks.Many<JobRespModel> sink = progressSinks.get(jobId);
        if (sink == null) {
            // Return an error if the jobId does not exist
            return Flux.just(ServerSentEvent.<JobRespModel>builder().comment("Job ID not found: " + jobId).event("progress-update").data(null).build());
        }
        // Get or create the Sinks.Many instance for the job
        return sink
                .asFlux()
                .map(jobRespModel -> ServerSentEvent.<JobRespModel>builder()
                        .event("progress-update") // Optional: Define an event name
                        .id(String.valueOf(jobId))               // Optional: Define an ID for the event
                        .data(jobRespModel)      // The actual data
                        .build());
    }
}
