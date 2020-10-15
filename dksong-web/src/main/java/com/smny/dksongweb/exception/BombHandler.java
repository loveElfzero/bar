package com.smny.dksongweb.exception;

import com.smny.dksongweb.utils.JsonRet;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Classname BombHandler
 * @Description TODO
 * @Date 2020/9/7 16:01
 * @Created by Administrator
 */
@RestControllerAdvice
public class BombHandler {

    @ExceptionHandler(BombException.class)
    public JsonRet resultData(BombException exception) {

        return JsonRet.buildFailRet(exception.getCode(), exception.getMessage());

    }


}
