package com.smny.dksongweb.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Classname UserEnum
 * @Description TODO
 * @Date 2020/9/7 11:05
 * @Created by Administrator
 */
@Getter
public enum UserEnum implements BaseEnum {
    USER_NOT_EXIST(201,"用户不存在"),
    USER_IS_EXIST(202,"用户已存在");

    private Integer code;
    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    UserEnum(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
