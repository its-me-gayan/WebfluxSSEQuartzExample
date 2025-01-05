package com.example.webfluxssequartzexample.service;


import com.example.webfluxssequartzexample.model.JobRespModel;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/4/25
 * Time: 11:42 PM
 */
public interface JobService {

    void updateJobProgress(Integer jobId, Double progress);

    public Flux<ServerSentEvent<JobRespModel>> getProgress(Integer jobId);
}
