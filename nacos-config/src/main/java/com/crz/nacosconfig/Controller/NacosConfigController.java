package com.crz.nacosconfig.Controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nacos")
//@RefreshScope
@NacosPropertySource(dataId = "nacos_config.properties",groupId = "DEFAULT_GROUP",autoRefreshed = true)
public class NacosConfigController {

    @NacosValue(value="${student.name}")
    private String name;

    @NacosValue(value="${student.age}")
    private String age;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return name+":"+age;
    }

}