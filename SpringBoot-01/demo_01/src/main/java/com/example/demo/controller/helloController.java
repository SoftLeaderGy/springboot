package com.example.demo.controller;

import com.example.demo.bean.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/07/25/20:45
 */
@RestController
public class helloController {
//
    @Value("${pet.name}")
    private String name;
//
//    @Value("${pet.weight}")
//    private Double weight;

    @Autowired
    private Pet pet;

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("pet")
    public String getPet(){
        return name;
    }
}
