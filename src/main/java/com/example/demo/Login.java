package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panbingcan on 2017/12/28.
 */
@RestController
@RequestMapping("login")
public class Login {

    //    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    public GirlProperties girlProperties;

    @GetMapping("get/{id}")
    public String Get(@PathVariable("id") Integer id) {
//        return "你好中国" + id + cupSize + age + "-----------" + content;
        return "你好中国" + id + girlProperties.getCupSize();
    }

    /*
    id设置默认值
    对外提供多个名字{get1,get2}
     */
    @GetMapping(value = "get1")
    public String Get1(@RequestParam(value = "id", required = false, defaultValue = "123") Integer myid) {
        return girlProperties.getCupSize() + myid;

    }
}
