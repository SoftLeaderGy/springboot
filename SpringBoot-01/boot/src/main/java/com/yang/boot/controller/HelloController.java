package com.yang.boot.controller;

import com.yang.boot.bean.Person;
import com.yang.boot.bean.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/04/19/17:27
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private Pet pet;
    @Autowired
    private Person person;

    @RequestMapping("/pet")
    public Pet pet(){
        return pet;
    }

    @RequestMapping("/person")
    public Person person(){
        log.info(person.getUserName());
        return person;
    }

//    @RequestMapping("/cp.jpg")
//    public String test(){
//        return "aaaa";
//    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
