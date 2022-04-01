package com.crz.nacosprovider01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.crz.nacosprovider01.dao"})
public class NacosProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider01Application.class, args);
    }

}
