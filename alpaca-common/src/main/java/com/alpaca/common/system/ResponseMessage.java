package com.alpaca.common.system;


import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.*;

/**
 * @Auther: song
 * @Date: 2018/11/8 14:54
 * @Description:
 * @Version:1.0.0
 */
public class ResponseMessage extends HashMap<String, Object> {

    private static String  SUCCESS_MSG ="操作成功";

    private static String  ERROR_MSG = "操作失败";

    private static final long serialVersionUID = 8992436576262574064L;



    public ResponseMessage() {
        put("code", 0);
    }

    public static ResponseMessage error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static ResponseMessage error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ResponseMessage error(int code, String msg) {
        ResponseMessage r = new ResponseMessage();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResponseMessage ok(String msg) {
        ResponseMessage r = new ResponseMessage();
        r.put("msg", msg);
        return r;
    }

    public static ResponseMessage ok(Map<String, Object> map) {
        ResponseMessage r = new ResponseMessage();
        r.put("msg",SUCCESS_MSG);
        r.putAll(map);
        return r;
    }

    public static ResponseMessage ok() {
        return ok(SUCCESS_MSG);
    }

    public static ResponseMessage ok(Object data) {
        ResponseMessage  r = new ResponseMessage();
        r.put("msg",SUCCESS_MSG);
        r.put("data",data);
        return  r;
    }

    public ResponseMessage put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
