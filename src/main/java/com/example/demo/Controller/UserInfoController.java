package com.example.demo.Controller;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import java.util.Date;
import java.util.List;

/**
 * Created by panbingcan on 2017/12/29.
 */
@RequestMapping("userInfo")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("getAll")
    public List<UserInfo> getAll() {
        return userInfoRepository.findAll();
    }

    @GetMapping("get/{id}")
    public UserInfo get(@PathVariable("id") Integer id) {
        return userInfoRepository.findOne(id);
    }

    @PostMapping("add")
    public UserInfo add(@RequestBody UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        return userInfoRepository.save(userInfo);
    }

    @PutMapping("update")
    public UserInfo update(@RequestBody UserInfo userInfo) {
        UserInfo u = userInfoRepository.findOne(userInfo.getId());
        userInfo.setCreateTime(u.getCreateTime());
        return userInfoRepository.save(userInfo);
    }

    //
//    @GetMapping("findByAge/{age}")
//    public List<UserInfo> findByAge(@PathVariable("age") Integer age) {
//        return userInfoRepository.findByAge(age);
//    }
    @GetMapping(value = "/get/age/{age}")
    public List<UserInfo> GirlListByAge(@PathVariable("age") Integer age) {
        return userInfoRepository.findByAge(age);
    }

    @DeleteMapping("delete/{id}")
    public HttpStatus delete(@PathVariable("id") Integer id) {
        userInfoRepository.delete(id);
        return HttpStatus.OK;
    }


}
