package com.yang.boot.config;

import com.yang.boot.beans.Car;
import com.yang.boot.beans.Pet;
import com.yang.boot.beans.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/04/11/19:08
 */
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类 == 配置文件
//@EnableConfigurationProperties(Car.class)
public class MyConfig {

//    @Bean
    public User user(){
        return new User("郭洋",23);
    }


//    @ConditionalOnBean(name = "user")
    @Bean
    @ConditionalOnMissingBean(name = "user")
    public Pet pet(){
        return new Pet("小一",1);
    }
}
