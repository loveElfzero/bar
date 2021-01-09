package com.mtp.bar.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class JsonRet<T> implements Serializable {

    private static final long serialVersionUID = -5515998627762098591L;
    private static final String SUCCESS="OK";
    private int code = 200;
    private String message = "";
    private T data;

    public JsonRet() {
    }


    public static <T> JsonRet<T> buildFailRet(Integer code, String message) {
        JsonRet<T> ret = new JsonRet<T>();
        ret.setCode(code);
        ret.setMessage(message);
        return ret;
    }

 

    public static <T> JsonRet<T> buildSuccRet(T data) {
        JsonRet<T> ret = new JsonRet<T>();
        ret.setMessage(SUCCESS);
        ret.setData(data);

        return ret;
    }

    public static <T> JsonRet<T> buildSuccRet() {
        JsonRet<T> ret = new JsonRet<T>();
        ret.setMessage(SUCCESS);

        return ret;
    }

    public static <T> JsonRet<T> buildFailRet(String errmsg) {
        JsonRet<T> ret = new JsonRet<T>();
        ret.setCode(-1);
        ret.setMessage(errmsg);
        ret.setData(null);
        log.info(JSON.toJSONString(ret));
        return ret;
    }

    public static <T> JsonRet<T> buildFailRet(String errmsg, T data) {
        JsonRet<T> ret = new JsonRet<T>();
        ret.setCode(-1);
        ret.setMessage(errmsg);
        ret.setData(data);
        log.info(JSON.toJSONString(ret));
        return ret;
    }


}
