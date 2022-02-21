package com.yang.aop.controller;

import com.yang.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HelloService helloService;
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return helloService.testServiceAop(name);
    }

    @RequestMapping("/A")
    public String A(@RequestParam("name") String name) {
        return helloService.A(name);
    }

    @RequestMapping("/testThrow")
    public String testThrow(@RequestParam("name") String name) {
        return helloService.testThrow(name);
    }
}
