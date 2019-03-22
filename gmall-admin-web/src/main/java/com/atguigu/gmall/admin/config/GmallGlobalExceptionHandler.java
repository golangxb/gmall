package com.atguigu.gmall.admin.config;

import com.atguigu.gmall.to.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Create with IntelliJ IDEA。
 * User : Lyhang
 * Data : 2019-03-20
 * Time : 20:48
 **/

@RestControllerAdvice//这是一个统一异常处理类
public class GmallGlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public Object handleNullPointException(Exception e){

        return new CommonResult().validateFailed(e.getMessage());
    }
}
