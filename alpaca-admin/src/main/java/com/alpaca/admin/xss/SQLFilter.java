package com.alpaca.admin.xss;


import com.alpaca.admin.exception.AlpacaException;
import com.alpaca.common.util.StringUtils;

/**
 * @ClassName: SQLFilter
 * @Description: 用于过滤sql ,防止sql注入
 * @Author：song
 * @Date: 2018/11/24 9:58
 * @Version: 1.0.0
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new AlpacaException("包含非法字符");
            }
        }

        return str;
    }
}
