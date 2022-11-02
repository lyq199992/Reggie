package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */

// 拦截注解
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody // 返回 json 数据
@Slf4j
public class GlobalExceptionHandler implements HandlerInterceptor {

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if (ex.getMessage().contains("Duplicate entry")){
            String message = ex.getMessage();
            String[] split = message.split(" ");
            String msg = split[2] + "已存在";

            return R.error(msg);
        }
        return R.error("未知错误");
    }
}
