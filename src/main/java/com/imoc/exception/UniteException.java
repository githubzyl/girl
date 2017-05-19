package com.imoc.exception;

import com.imoc.enums.ResultError;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/19
 * @Time : 14:10
 * @Description : 自定义异常处理
 */
public class UniteException extends RuntimeException {

    private String code;

    public UniteException(ResultError resultError){
        super(resultError.getMessage());
        this.code = resultError.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
