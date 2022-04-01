package com.crz.mybatisplus.controller;


import com.crz.mybatisplus.entity.RobotExecuteLog;
import com.crz.mybatisplus.mapper.RobotExecuteLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rzcai
 * @since 2022-03-21
 */
@RestController
@RequestMapping("/mybatisplus/robot-execute-log")
public class RobotExecuteLogController {

    @Autowired
    private RobotExecuteLogMapper robotExecuteLogMapper;

    @GetMapping("/test")
    public String test(){
        List<RobotExecuteLog> list=robotExecuteLogMapper.selectList(null);
        return list.toString();
    }

}

