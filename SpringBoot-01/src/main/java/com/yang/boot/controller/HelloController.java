package com.yang.boot.controller;

import com.yang.boot.beans.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInput;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/04/11/17:09
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private Car car;

    @Value("mycar.brand")
    private String brand;
    @Value("mycar.price")
    private Integer price;
    @RequestMapping("/hello")
    public String hello(){

        log.info("请求进来了。。。");

        return brand+price;
//        return "Hello SpringBoot2";
    }
    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }

    @RequestMapping("111")
    public String hello111(){
        return brand+price;
    }
}
