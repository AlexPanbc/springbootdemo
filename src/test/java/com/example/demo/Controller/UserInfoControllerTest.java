package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by Alex on 2018/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserInfoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/userInfo/getAll")).andExpect(MockMvcResultMatchers.status().isOk());//.andExpect(MockMvcResultMatchers.content().string("abc"));
    }

    @Test
    public void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/userInfo/get/100")).andExpect(MockMvcResultMatchers.status().isOk());//.andExpect(MockMvcResultMatchers.content().string("abc"));
    }

    @Test
    public void add() throws Exception {
        UserInfo u = new UserInfo();
        u.setCupSize("G");
        u.setImg("http://www.baidu.com");
        u.setName("重大");
        u.setAge(19);
        u.setHeight(150);
        u.setWeight(66);
        u.setCreateTime(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(post("/userInfo/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(u)))
                .andExpect(MockMvcResultMatchers.status().isOk());
               // .andExpect(MockMvcResultMatchers.content().string("重大"));
    }

    @Test
    public void addExecptoin() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void findByCupSize() throws Exception {

    }

    @Test
    public void girlListByAge() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getAge() throws Exception {

    }

    @Test
    public void addList() throws Exception {

    }

    @Test
    public void getPageing() throws Exception {

    }

    @Test
    public void getPageSort() throws Exception {

    }

    @Test
    public void getPageParam() throws Exception {

    }

    @Test
    public void diyGetUserInfoByMaxId() throws Exception {

    }

    @Test
    public void diyGetUserInfoByNameAndAge() throws Exception {

    }

    @Test
    public void diyGetUserInfoByNameAndAge2() throws Exception {

    }

    @Test
    public void diyGetUserInfoCount() throws Exception {

    }

}