package com.yang.aop.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/26/10:44
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return name;
    }
}
