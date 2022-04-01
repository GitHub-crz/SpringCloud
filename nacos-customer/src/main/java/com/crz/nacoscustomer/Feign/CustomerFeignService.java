package com.crz.nacoscustomer.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-provider")
public interface CustomerFeignService {

    @RequestMapping("/provider/test")
    public String test(@RequestParam("info") String info);
}
