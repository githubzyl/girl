package com.imoc.enums;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/19
 * @Time : 14:32
 * @Description :
 */
public enum ResultError {

    UNKNOW_ERROR("-1","未知错误"),
    SUCCESS("0","成功"),
    PRIMARY_SCHOOL("100","你还在上小学吧"),
    MIDDLE_SCHOOL("101","你可能还在上初中吧")
    ;


    private String code;
    private String message;

    ResultError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
