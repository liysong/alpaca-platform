package com.alpaca.common.state;

/**
 * @Auther: song
 * @Date: 2018/11/7 10:14
 * @Description:  任务状态描述
 * @Version:1.0.0
 */
public enum TaskState {

    STATE_UN_KNOW ( -1,"未知状态"),

    STATE_INIT ( 0,"等待执行"),

    STATE_WAITING ( 1,"等待执行"),

    STATE_RUNNING ( 2,"正在执行"),

    STATE_SUCCESS ( 3,"执行成功"),

    STATE_FAIL ( 4,"执行失败"),

    STATE_CLOSED ( 5,"用户关闭"),

    STATE_CHECK_ERROR ( 6,"校验错误"),

    STATE_PARTSUCCESS ( 31,"任务部分执行成功");

    int  status;

    String desc;

    TaskState(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static TaskState getTaskStatus(int  status){

        for(TaskState taskStatus:values()){
            if(taskStatus.status == status){
                return  taskStatus;
            }
        }

        return  STATE_UN_KNOW;
    }
}
