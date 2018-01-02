package com.example.demo.Controller;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.Service.UserInfoService;
import com.example.demo.domain.Result;
import com.example.demo.domain.UserInfo;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by panbingcan on 2017/12/29.
 */
@RequestMapping("userInfo")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;
    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @GetMapping("getAll")
    public Result<List<UserInfo>> getAll() {
        logger.info("getAll方法里头");
        return ResultUtil.success(userInfoRepository.findAll());
    }

    @GetMapping("get/{id}")
    public Result<UserInfo> get(@PathVariable("id") Integer id) {
        return ResultUtil.success(userInfoRepository.findOne(id));
    }

    @PostMapping("add")
    public Result<UserInfo> add(@Valid @RequestBody UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        userInfo.setCreateTime(new Date());
        return ResultUtil.success(userInfoRepository.save(userInfo));
    }

    /**
     * 未满18岁禁止入内 验证系统异常信息
     * localhost:8080/userInfo/addExecptoin
     * {
     * "age": 12,
     * "name": "中3文",
     * "cupSize": "F",
     * "height": 172,
     * "weight": 50,
     * "img": "http://www.baidu.com"
     * }
     * 目的达到
     * {
     * "code": -1,
     * "msg": "未知错误",
     * "data": null
     * }
     *
     * @param userInfo
     * @param bindingResult
     * @return
     */
    @PostMapping("addExecptoin")
    public Result<UserInfo> addExecptoin(@Valid @RequestBody UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
        /**
         *  {
         "id": 2,
         "age": 17,
         "name": "测试异常数据",
         "cupSize": "F",
         "height": 170,
         "weight": 51,
         "img": "http://www.baidu.com"
         }
         */
            // return null;//系统异常实例 localhost:8080/userInfo/addExecptoin
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        userInfo.setCreateTime(new Date());
        return ResultUtil.success(userInfoRepository.save(userInfo));
    }

    @PutMapping("update")
    public Result<UserInfo> update(@Valid @RequestBody UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        UserInfo u = userInfoRepository.findOne(userInfo.getId());
        userInfo.setCreateTime(u.getCreateTime());
        return ResultUtil.success(userInfoRepository.save(userInfo));
    }

    @GetMapping("findByCupSize")
    public Result<List<UserInfo>> FindByCupSize(@RequestParam("cupSize") String cupSize) {
        return ResultUtil.success(userInfoRepository.findByCupSize(cupSize));
    }

    @GetMapping(value = "/get/age/{age}")
    public Result<List<UserInfo>> GirlListByAge(@PathVariable("age") Integer age) {
        return ResultUtil.success(userInfoRepository.findByAge(age));
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        userInfoRepository.delete(id);
        return ResultUtil.success();
    }

    @GetMapping(value = "getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        userInfoService.getAge(id);
    }
}
