package com.top.sstore.common;

import com.top.sstore.utils.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zh
 * @date 2019/6/4/004 20:54
 * 全局异处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Message errorHandler(Exception e){
        return Message.fail("global error:"+e.getClass().getName());
    }
}
