package com.yang.aop.service;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {
    String testServiceAop(String name);


    /**
     * 测试拦截Service层返回数据
     * @param name
     * @return
     */
    String A(String name);

    /**
     * 测试抛异常
     * @param name
     * @return
     */
    String testThrow(String name);
}
