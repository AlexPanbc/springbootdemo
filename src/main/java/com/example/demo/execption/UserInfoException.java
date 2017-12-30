package com.example.demo.execption;

import com.example.demo.enums.ResultEnum;

/**
 * Created by Alex on 2017/12/30.
 */
public class UserInfoException extends RuntimeException {
    private Integer code;

    public UserInfoException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
