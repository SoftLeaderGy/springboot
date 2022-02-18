package com.yang.boot.test;

import com.yang.boot.bean.Person;
import org.apache.maven.model.Site;
import org.junit.jupiter.api.Test;

/**
 * @Description: 测试
 * @Author: Yang.Guo
 * @Date: 2021/07/28/20:31
 */
public class myTest {

    @Test
    public void test(){
        Person p = new Person();
        p.setUserName("qwe");

        Person p1 = new Person();
        p1.setUserName("aaa");

        System.out.println(p1);
        System.out.println("**************");
        System.out.println(p);

    }
}
