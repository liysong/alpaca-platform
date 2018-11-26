package com.alpaca.common.util;

/**
 * @ClassName: IdGenerator
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/10 18:44
 * @Version: 1.0.0
 */
public class IdGenerator {

    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);

    public static String  getNextId(){
      return   String.valueOf(snowflakeIdWorker.nextId());
    }
}
