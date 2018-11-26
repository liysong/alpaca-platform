package com.alpaca.common.util;

import java.util.UUID;

/**
 * @ClassName: UuidUtil
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/2 22:39
 * @Version: 1.0.0
 */
public class UuidUtil {

    /**
     * 生成一个带【-】的uuid
     * @return
     */
    public static  String getUuid(){
        return UUID.randomUUID().toString();
    }

    public  static  String getUUidReplace(){
        return UUID.randomUUID().toString().replace("-", "");
    }


}

