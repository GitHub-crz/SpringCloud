package com.crz.nacoscustomer.Controller;

import com.crz.nacoscustomer.Feign.CustomerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerFeignService customerFeignService;

    @RequestMapping("/test")
    public String test(){
        return customerFeignService.test("success");
    }
}
