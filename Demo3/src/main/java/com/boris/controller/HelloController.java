package com.boris.controller;

import com.boris.bean.Person;
import com.boris.bean.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyong
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Pet pet;

    @RequestMapping("/pet")
    public Pet pet() {
        return pet;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {
        log.info("请求进来了。。。");
        return "Hello,SpringBoot 2!"+"您好，"+name;
    }

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }
}
