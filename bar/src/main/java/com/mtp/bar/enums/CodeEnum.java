package com.mtp.bar.enums;

import lombok.Getter;

/**
 * @Classname CodeEnum
 * @Description 验证码
 * @Date 2020/9/7 11:05
 * @Created by Administrator
 */
@Getter
public enum CodeEnum implements BaseEnum {
    CODE_ERROR(201,"验证码错误"),
    CODE_NOT_EXIST(201,"验证码不存在"),
    USER_IS_EXIST(202,"用户已存在"),
    USER_PASSWORD_ERROE(203,"密码错误，请重新输入"),
    CODE_TOKEN(403,"用户已在别处登陆"),
    USER_AVAILABLE(204,"用户已禁用");

    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    CodeEnum(Integer code) {
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
