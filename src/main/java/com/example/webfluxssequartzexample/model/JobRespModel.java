package com.example.webfluxssequartzexample.model;


import lombok.Builder;
import lombok.Data;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/5/25
 * Time: 8:12 PM
 */
@Data
@Builder(toBuilder = true)
public class JobRespModel {
    private int id;
    private String jobName;
    private String jobGroup;
    private String jobDescription;
    private Double jobProgress;
    private String jobStatus;
}
