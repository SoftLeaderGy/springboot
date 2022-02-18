package com.yang.boot;

import com.yang.boot.beans.User;
import com.yang.boot.config.MyConfig;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/04/11/17:05
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 返回IOC容器，也就是项目中被SpringBoot加载的所有组件
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 返回所有被加载组件的名字
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

//        MyConfig bean = run.getBean(MyConfig.class);
//        User user = bean.user();
//        User user1 = bean.user();



//        System.out.println(user == user1);


    }
}
