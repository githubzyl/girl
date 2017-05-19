package com.imoc.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/18
 * @Time : 22:13
 * @Description :
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imoc.web.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求的路径
        logger.info("url={}",request.getRequestURL());
        //请求方式
        logger.info("method={}",request.getMethod());
        //客户端ip
        logger.info("ip={}",request.getRemoteAddr());
        //请求的类方法
        Signature signature = joinPoint.getSignature();
        logger.info("class_method={}",signature.getDeclaringTypeName() + "." + signature.getName());
        //请求的参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("pointCut()")
    public void logEnd(){
        logger.info("222222");
    }

    @AfterReturning(value = "pointCut()",returning = "object")
    public void afterReturn(Object object){
        logger.info("response={}",object.toString());
    }

}
