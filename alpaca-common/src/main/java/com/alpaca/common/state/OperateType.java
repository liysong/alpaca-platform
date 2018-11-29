package com.alpaca.common.state;

/**
 * @ClassName: OperateType
 * @Description: 操作日志类型
 * @Author：song
 * @Date: 2018/11/11 21:25
 * @Version: 1.0.0
 */
public enum OperateType {

    SAVE(1),
    UPDATE(2),
    DELETE(3),

    LOGIC_DELETE(4), //逻辑删除数据
    LOGIN(5),
    QUERY(6),
    OTHERS(7); //其他操作

    int type;

    OperateType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
