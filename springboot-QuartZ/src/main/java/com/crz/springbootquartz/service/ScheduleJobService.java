package com.crz.springbootquartz.service;


/**
 * @author Andya
 * @create 2021/04/01
 */
public interface ScheduleJobService {

    /**
     * job1定时任务
     * @throws Exception
     */
    void scheduleJob1() throws Exception;

    /**
     * job2定时任务
     * @throws Exception
     */
    void scheduleJob2() throws Exception;
}


