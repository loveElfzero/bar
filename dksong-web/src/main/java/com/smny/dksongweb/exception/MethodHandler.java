package com.smny.dksongweb.exception;

import com.smny.dksongweb.utils.JsonRet;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Classname MethodHandler
 * @Description 返回参数异常处理
 * @Date 2020/9/7 18:19
 * @Created by yuan jing
 */
@RestControllerAdvice
public class MethodHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public JsonRet resultData(Exception exception) {

        if (exception instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) exception).getBindingResult();
            return JsonRet.buildFailRet(204, bindingResult.getFieldError().getDefaultMessage());
        } else if (exception instanceof BindException) {
            BindingResult bindingResult = ((BindException) exception).getBindingResult();
            return JsonRet.buildFailRet(204, bindingResult.getFieldError().getDefaultMessage());
        }

        return JsonRet.buildFailRet(204, "参数异常");
    }

}
