package com.alpaca.common.state;

/**
 * @Auther: song
 * @Date: 2018/11/7 10:44
 * @Description:
 * @Version:1.0.0
 */
public enum TaskTypeState {
    READ_LOCAL_FILE (11,"读取本地文件"),

    READ_REMOTE_FILE (12,"读取远程文件"),

    READ_DB_DATA (13,"读取数据库数据"),

    READ_HDFS_FILE (14,"读取hdfs文件"),

    WRITE_LOCAL_FILE (21,"写本地文件"),

    WRITE_REMOTE_FILE (22,"远程文件写入"),

    WRITE_DB_DATA (23,"数据写入数据库"),

    WRITE_HDFS_FILE (24,"数据写入hdfs"),

    MEMORY_DATA_PROCESSING (31,"内存处理"),

    DATA_INITIALIZATION (41,"数据初始化，环境初始化");

    int  type;

    String  desc;

    TaskTypeState(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
