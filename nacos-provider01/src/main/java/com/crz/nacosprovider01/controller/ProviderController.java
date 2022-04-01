package com.crz.nacosprovider01.controller;


import com.crz.nacosprovider01.entity.Student;
import com.crz.nacosprovider01.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/test")
    public String test(String info){
        return "模块1接收到的信息："+info;
    }

    @GetMapping("selectAll")
    public List<Student> selectAll() {
        return this.studentService.queryAll();
    }


}
