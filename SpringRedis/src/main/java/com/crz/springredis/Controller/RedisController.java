package com.crz.springredis.Controller;

import com.crz.springredis.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.*;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/1 9:54
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @RequestMapping("test")
    public String test_redis(){
        UserEntity user=new UserEntity();
        user.setId(1L);
        user.setUserName("crz");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user", user);
        UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
        return user2.getUserName();
    }
    @RequestMapping("get-keys")
    public List<String> get_all_keys(){
        List<String > keys=new LinkedList<>();
        Set<String> set=new HashSet<>();
        set=serializableRedisTemplate.opsForValue().getOperations().keys("*");
        Iterator<String > it=set.iterator();
        while (it.hasNext())keys.add(it.next());
        return keys;
    }

}
