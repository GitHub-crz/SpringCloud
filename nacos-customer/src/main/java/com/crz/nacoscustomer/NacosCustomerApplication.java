package com.crz.nacoscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.crz.nacoscustomer.Feign")
public class NacosCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosCustomerApplication.class, args);
    }

}
