package com.ha.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("실행, desc: {}", context.getJobDetail().getDescription());
        log.info("key: {}", context.getJobDetail().getKey().getName());
    }
}