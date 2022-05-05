package com.crz.springbootquartz.service;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/5/5 16:23
 */

import org.quartz.Job;

import java.util.Date;

/**
 * Quartz定时任务操作类
 * Created by macro on 2020/9/27.
 */
public interface ScheduleService {
    /**
     * 通过CRON表达式调度任务
     */
    String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data);

    /**
     * 调度指定时间的任务
     */
    String scheduleFixTimeJob(Class<? extends Job> jobBeanClass, Date startTime, String data);

    /**
     * 取消定时任务
     */
    Boolean cancelScheduleJob(String jobName);
}
