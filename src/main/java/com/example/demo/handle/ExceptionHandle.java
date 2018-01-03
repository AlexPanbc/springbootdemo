package com.example.demo.handle;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Result;
import com.example.demo.execption.UserInfoException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Alex on 2017/12/30.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception exception) {
        if (exception instanceof UserInfoException) {
            UserInfoException userInfoException = (UserInfoException) exception;
            return ResultUtil.error(userInfoException.getCode(), userInfoException.getMessage());
        }
        logger.error("【系统异常】{}", exception);
        return ResultUtil.error(-1, "未知错误:" + JSON.toJSONString(exception));// JSONObject.toJSONString(exception)
    }
}
