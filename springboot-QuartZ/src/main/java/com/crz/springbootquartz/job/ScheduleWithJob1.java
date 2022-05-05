package com.crz.springbootquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author Andya
 * @create 2021/04/01
 */
@Slf4j
public class ScheduleWithJob1 extends QuartzJobBean {

    @Autowired
    ScheduleJobService scheduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException{
        System.out.println("start schedule job1: " + LocalDateTime.now());
        try {
            scheduleJobService.scheduleWithJob1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


