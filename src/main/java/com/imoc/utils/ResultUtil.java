package com.imoc.utils;

import com.imoc.entity.Result;
import com.imoc.enums.ResultError;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/19
 * @Time : 13:34
 * @Description :
 */
public class ResultUtil {

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultError.SUCCESS.getCode());
        result.setMsg(ResultError.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result fail(String code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(ResultError resultError){
        Result result = new Result();
        result.setCode(resultError.getCode());
        result.setMsg(resultError.getMessage());
        return result;
    }

}
