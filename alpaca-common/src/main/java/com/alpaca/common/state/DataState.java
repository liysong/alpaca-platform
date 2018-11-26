package com.alpaca.common.state;

/**
 * @Auther: song
 * @Date: 2018/11/7 10:54
 * @Description: 数据的状态，0:该数据不能使用,1：该数据可以使用;<br>
 *
 * @Version:1.0.0
 */
public enum DataState {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    int code;

    String desc;

    DataState(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
