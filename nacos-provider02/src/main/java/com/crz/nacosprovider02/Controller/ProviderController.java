package com.crz.nacosprovider02.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @RequestMapping("/test")
    public String test(String info){
        return "模块2接收到的信息："+info;
    }
}
