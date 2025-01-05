package com.example.webfluxssequartzexample.config;


import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 1/5/25
 * Time: 9:08 PM
 */
@Component
public class SpringJobFactory extends AdaptableJobFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringJobFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        // Autowire the job instance with Spring context
        applicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
        return jobInstance;
    }
}