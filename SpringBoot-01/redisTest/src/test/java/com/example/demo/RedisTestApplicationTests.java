package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTestApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void save(){
        redisTemplate.opsForValue().set("redisTest","99",1,TimeUnit.MINUTES);
    }


    @Test
    public void get() {
        String redisTest = (String)redisTemplate.opsForValue().get("redisTest");
        System.out.println(redisTest);
    }
}
