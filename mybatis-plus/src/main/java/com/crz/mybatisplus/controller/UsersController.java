package com.crz.mybatisplus.controller;


import com.crz.mybatisplus.entity.Users;
import com.crz.mybatisplus.mapper.UsersMapper;
import com.crz.mybatisplus.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rzcai
 * @since 2022-04-01
 */
@RestController
@RequestMapping("/mybatisplus/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;


    @RequestMapping("list")
    public String list(){
        List<Users> list=usersMapper.selectList(null);
        return list.toString();
    }
}

