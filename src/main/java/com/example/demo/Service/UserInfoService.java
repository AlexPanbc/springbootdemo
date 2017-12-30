package com.example.demo.Service;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.domain.UserInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.execption.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alex on 2017/12/30.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    public void getAge(Integer id) throws Exception
    {
        UserInfo userInfo =userInfoRepository.findOne(id);
        Integer age = userInfo.getAge();
        if(age<10)
            throw new UserInfoException(ResultEnum.PRIMARY_SCHOOL);
        if(age>10 && age <16)
            throw  new UserInfoException(ResultEnum.Middle_SCHOOL);
    }
}
