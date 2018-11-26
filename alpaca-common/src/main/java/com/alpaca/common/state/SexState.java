package com.alpaca.common.state;

/**
 * @Auther: song
 * @Date: 2018/11/7 11:06
 * @Description:
 * @Version:1.0.0
 */
public enum  SexState {
    MEN(1,"男"),
    WOMEN(0,"女");

    int type;

    String desc;

    SexState(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
