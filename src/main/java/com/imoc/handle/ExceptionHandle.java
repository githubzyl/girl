package com.imoc.handle;

import com.imoc.entity.Result;
import com.imoc.enums.ResultError;
import com.imoc.exception.UniteException;
import com.imoc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/19
 * @Time : 13:57
 * @Description : 统一异常处理类
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof UniteException){
            UniteException uniteException = (UniteException)e;
            return ResultUtil.fail(uniteException.getCode(),e.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.fail(ResultError.UNKNOW_ERROR);
        }
    }

}
