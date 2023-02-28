package com.xucl.controller;

import com.xucl.exception.BusinessException;
import com.xucl.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xucl
 * @apiNote
 * @date 2023/2/24 09:23
 */

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        System.out.println("嘿嘿，异常你跑哪去了");
        return new Result(Code.SYSTEM_UNKNOWN_ERROR, null, "系统繁忙，请稍后再试!");
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {

        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException businessException) {

        // 记录日志
        // 发送消息给开发人员
        return new Result(businessException.getCode(), null, businessException.getMessage());
    }

}
