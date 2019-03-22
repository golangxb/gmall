package com.atguigu.gmall.admin.config;

import com.atguigu.gmall.to.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Create with IntelliJ IDEA。
 * User : Lyhang
 * Data : 2019-03-20
 * Time : 20:24
 **/
@Slf4j
@Component
@Aspect
public class GmallValidatorAspect {
    @Around("execution(* com.atguigu.gmall..*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object obj:args) {
            if(obj instanceof BindingResult){
                if(((BindingResult) obj).getErrorCount()>0){
                    log.info("校验发生了错误");
                    return new CommonResult().validateFailed((BindingResult) obj);
                }
            }
        }

        Object proceed = proceedingJoinPoint.proceed();

        return proceed;
    }

}
