package com.crz.springbootquartz.job;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/5/5 16:54
 */

import com.crz.springbootquartz.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 发送邮件定时任务执行器
 * Created by macro on 2020/9/27.
 */
@Slf4j
@Component
public class SendEmailJob extends QuartzJobBean {
    @Autowired
    private ScheduleService scheduleService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Trigger trigger = jobExecutionContext.getTrigger();
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String data = jobDataMap.getString("data");
        log.info("定时发送邮件操作：{}",data);
        //完成后删除触发器和任务
        scheduleService.cancelScheduleJob(trigger.getKey().getName());
    }
}
