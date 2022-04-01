package com.crz.nacosprovider03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider03Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider03Application.class, args);
    }

}
