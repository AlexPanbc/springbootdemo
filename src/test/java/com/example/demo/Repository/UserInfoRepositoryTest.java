package com.example.demo.Repository;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by Alex on 2018/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void findByAge() throws Exception {
        System.out.println("结果：" + JSON.toJSONString(userInfoRepository.findByAge(20)));
    }

    @Test
    public void findByCupSize() throws Exception {
        System.out.println("结果：" + JSON.toJSONString(userInfoRepository.findByCupSize("F")));
    }

    @Test
    public void diyGetUserInfoByMaxId() throws Exception {
        System.out.println("结果：" + JSON.toJSONString(userInfoRepository.diyGetUserInfoByMaxId()));
    }

    @Test
    public void diyGetUserInfoByNameAndAge() throws Exception {
        System.out.println("diyGetUserInfoByNameAndAge结果：" + JSON.toJSONString(userInfoRepository.diyGetUserInfoByNameAndAge("test", 30)));
    }

    @Test
    public void diyGetUserInfoByNameAndAge2() throws Exception {
        System.out.println("diyGetUserInfoByNameAndAge2结果：" + JSON.toJSONString(userInfoRepository.diyGetUserInfoByNameAndAge2("test11", 50)));
    }

    @Test
    public void diyGetUserInfoCount() throws Exception {
        System.out.println("diyGetUserInfoCount结果：" + JSON.toJSONString(userInfoRepository.diyGetUserInfoCount()));
    }

}