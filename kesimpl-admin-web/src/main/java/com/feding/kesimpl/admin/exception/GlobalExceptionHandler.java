package com.feding.kesimpl.admin.exception;

import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({NullPointerException.class,Exception.class,RuntimeException.class})
    public Object exceptionHandler(Exception e) {
        if (e instanceof NullPointerException) {
            e = (NullPointerException) e;
            log.error("空指针异常：[{}]={}",e.getMessage(), e.getStackTrace());
           return new CommonResult().validateFailed("NullPointerException:"+e.getMessage());
        }
        if (e instanceof ClassNotFoundException){
            e= (ClassNotFoundException)e;
            log.error("类找不到：[{}]={}",e.getMessage(),e.getStackTrace());
            return new CommonResult().validateFailed("ClassNotFoundException");
        }

        if (e instanceof ClassCastException){
            e= (ClassCastException)e;
            log.error("类型转换失败：[{}]={}",e.getMessage(),e.getStackTrace());
            return new CommonResult().validateFailed("classCastException");
        }
        if (e instanceof SQLException){
            e= (SQLException)e;
            log.error("数据库操作异常：[{}]={}",e.getMessage(),e.getStackTrace());
            return new CommonResult().validateFailed("sqlException");
        }

        log.error("出现异常：【{}】:=={}",e.getMessage(),e.getStackTrace());
        return new CommonResult().validateFailed("未知异常，请查看栈堆信息");
    }

}
