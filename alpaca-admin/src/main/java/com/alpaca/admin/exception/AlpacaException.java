package com.alpaca.admin.exception;

/**
 * @ClassName: AlpacaException
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 9:47
 * @Version: 1.0.0
 */
public class AlpacaException extends RuntimeException {


    private String msg;
    private int code = 500;

    public AlpacaException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AlpacaException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AlpacaException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AlpacaException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
