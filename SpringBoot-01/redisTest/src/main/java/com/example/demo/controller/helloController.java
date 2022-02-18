package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dto.HelloDTO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2021/10/09/14:55
 */
@RestController
public class helloController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String helloController(@RequestBody HelloDTO helloDTO){
        redisTemplate.opsForValue().set("hello",helloDTO,1, TimeUnit.MINUTES);
        return "hello";
    }

    @RequestMapping("/getHello")
    public String getHelloController(@RequestBody HelloDTO helloDTO){
        try {
            Object o = redisTemplate.opsForValue().get(helloDTO.getMsg());
            if(o == null){
                throw new RuntimeException("键值过期！");
            }
            String s1 = JSONObject.toJSONString(o);
            return s1;
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
