package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Entity.UserInfoEntityPage;
import com.example.demo.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Alex on 2018/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getAge() throws Exception {
        userInfoService.getAge(50);
    }

    @Test
    public void addList() throws Exception {
        userInfoService.addList();
    }

    @Test
    public void getPageing() throws Exception {
        Page<UserInfo> page = userInfoService.getPageing(0, 10);
        System.out.println("结果：" + JSON.toJSONString(page));
    }

    @Test
    public void getPageSort() throws Exception {
        Page<UserInfo> page = userInfoService.getPageSort(0, 2, 100, "F");
        System.out.println("结果：" + JSON.toJSONString(page));
    }

    @Test
    public void getPageParam() throws Exception {
        UserInfoEntityPage u = new UserInfoEntityPage();
        u.setAge(20);
        u.setName("test11");
        u.setCupSize("F");
        Page<UserInfo> page = userInfoService.getPageParam(0, 2, u);
        System.out.println("结果：" + JSON.toJSONString(page));
    }

}