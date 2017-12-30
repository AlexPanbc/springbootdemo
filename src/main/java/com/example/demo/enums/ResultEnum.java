package com.example.demo.enums;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by Alex on 2017/12/30.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    Middle_SCHOOL(101, "你可能在上初中"),;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
