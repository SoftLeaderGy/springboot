package com.yang.aop.service.impl;

import com.yang.aop.service.HelloService;
import org.springframework.stereotype.Service;

@Service("HelloServiceImpl")
public class HelloServiceImpl implements HelloService {
    @Override
    public String testServiceAop(String name) {
        return name;
    }

    @Override
    public String A(String name) {
        return "name";
    }

    @Override
    public String testThrow(String name) {
        throw new RuntimeException("测试抛异常");
    }
}
