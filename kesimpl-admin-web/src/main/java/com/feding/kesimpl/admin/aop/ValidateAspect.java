package com.feding.kesimpl.admin.aop;

import com.feding.kesimpl.to.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * 数据校验切面类
 */

@Component
@Aspect
public class ValidateAspect {
    private static final Logger log = LoggerFactory.getLogger(ValidateAspect.class);

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.feding.kesimpl.admin.ums..*Controller.*(..))")
    public Object validateAround(ProceedingJoinPoint joinPoint) {
        Object proceed ;
        BindingResult result;
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof BindingResult) {
                result = (BindingResult) obj;
                int errorCount= result.getErrorCount();
                if (errorCount> 0) {
                    log.error("数据校验失败,属性：{},信息：{}", result.getFieldError().getField(), result.getFieldError().getDefaultMessage());
                    return new CommonResult().validateFailed(result.getFieldError().getDefaultMessage());
                }
            }
        }
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("切面检查到异常:{}", throwable.getMessage());
            throw new RuntimeException(throwable);
        }
        return proceed;


    }
}
