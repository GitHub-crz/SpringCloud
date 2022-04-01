package com.crz.nacosprovider03.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @RequestMapping("/test")
    public String test(String info){
        return "模块3接收到的信息："+info;
    }
}
