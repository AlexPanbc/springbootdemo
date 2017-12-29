package com.example.demo.Controller;

import com.example.demo.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panbingcan on 2017/12/28.
 */
import java.text.*;
import java.util.Date;

@RestController
@RequestMapping("login")
public class LoginController {

    //    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    public GirlProperties girlProperties;

    @GetMapping("getTime")
    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

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
