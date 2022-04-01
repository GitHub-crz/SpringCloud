package com.crz.mybatisplus;

import com.crz.mybatisplus.entity.RobotExecuteLog;
import com.crz.mybatisplus.mapper.RobotExecuteLogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    private RobotExecuteLogMapper robotExecuteLogMapper;
    @Test
    void contextLoads() {
        List<RobotExecuteLog> list=robotExecuteLogMapper.selectList(null);
        System.out.println(list.toString());
    }

}
