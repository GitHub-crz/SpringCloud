package com.crz.springbootquartz.controller;


import com.andya.selfcode.quartz.bean.UpdateJobBean;
import com.andya.selfcode.quartz.bean.JobXXXBean;
import com.andya.selfcode.quartz.exception.BadRequestException;
import com.andya.selfcode.quartz.service.QuartzService;
import com.andya.selfcode.quartz.service.jobs.Job1;
import com.crz.springbootquartz.service.QuartzService;
import io.swagger.annotations.*;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Andya
 * @create 2021/04/01
 */
@RestController
//@Api(value = "quartz增删改查相关API")
@RequestMapping(value = "/quartz")
public class YarnFlexibleCapacityExpansionController {

    @Autowired
    QuartzService quartzService;

    @ApiOperation(value = "使用quartz添加job")
    @RequestMapping(value = "/addJob/{jobUUID}", method = RequestMethod.POST)
    public void addQuartzJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID,
            @ApiParam(name = "JobXXXBean") @RequestBody JobXXXBean jobXXXBean) {

        if (jobXXXBean.getOpenBean() != null) {
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("key01", jobXXXBean.getKey01());
            jobDataMap.put("key02", jobXXXBean.getKey02());
            jobDataMap.put("key03", jobXXXBean.getKey03());
            jobDataMap.put("jobTimeCron", jobXXXBean.getJobTimeCron());
            jobDataMap.put("key04", jobXXXBean.getKey04());
            quartzService.addJob(Job1.class,
                    jobUUID,
                    jobUUID,
                    jobXXXBean.getJobTimeCron(),
                    jobDataMap);
        } else {
            throw new BadRequestException("参数错误");
        }
    }


    @ApiOperation(value = "使用quartz查询所有job")
    @RequestMapping(value = "/queryAllJob", method = RequestMethod.GET)
    public List<Map<String, Object>> queryAllQuartzJob() {

        List<Map<String, Object>> list = quartzService.queryAllJob();
        return list;
    }


    @ApiOperation(value = "使用quartz查询所有运行job")
    @RequestMapping(value = "/queryRunJob", method = RequestMethod.GET)
    public List<Map<String, Object>> queryRunQuartzJob() {

        List<Map<String, Object>> list = quartzService.queryRunJob();
        return list;
    }

    @ApiOperation(value = "使用quartz删除job")
    @RequestMapping(value = "/deleteJob/{jobUUID}", method = RequestMethod.DELETE)
    public void deleteJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID) {

        quartzService.deleteJob(jobUUID, jobUUID);
    }


    @ApiOperation(value = "使用quartz修改job的cron时间")
    @RequestMapping(value = "/updateJob/{jobUUID}", method = RequestMethod.PUT)
    public void deleteJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID,
            @ApiParam(name = "jobCronTime") @RequestBody UpdateJobBean updateJobBean) {

        quartzService.updateJob(jobUUID, jobUUID, updateJobBean.getJobCronTime());

    }
}


/**
 * @author Andya
 * @create 2021/04/01
 */
@ApiModel(value = "更新job cron时间参数")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateJobBean {
    @ApiModelProperty(value = "jobTime的cron表达式", example = "0 0 1 * * ?")
    String jobCronTime;

    public String getJobCronTime() {
        return jobCronTime;
    }

    public void setJobCronTime(String jobCronTime) {
        this.jobCronTime = jobCronTime;
    }
}

