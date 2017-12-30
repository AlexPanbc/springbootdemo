package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * Created by Alex on 2017/12/30.
 */
public class ResultUtil {
    /**
     * 成功返回值
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功返回null
     * @return
     */
    public static  Result success()
    {
        return success(null);
    }

    /**
     * 失败返回值
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg)
{
    Result result = new Result();
    result.setCode(code);
    result.setMsg(msg);
    return result;
}
}
