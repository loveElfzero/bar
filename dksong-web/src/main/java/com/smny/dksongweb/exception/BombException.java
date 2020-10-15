package com.smny.dksongweb.exception;

import com.smny.dksongweb.enums.BaseEnum;
import lombok.Getter;

/**
 * @Classname BombException
 * @Description TODO
 * @Date 2020/9/7 11:03
 * @Created by Administrator
 */
@Getter
public class BombException extends RuntimeException {

    private Integer code;

    public BombException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BombException(BaseEnum baseEnum){
        super(baseEnum.getMessage());
        this.code=baseEnum.getCode();

    }


}
