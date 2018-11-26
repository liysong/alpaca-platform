package com.alpaca.common.util;

import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5Uilts
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/2 22:36
 * @Version: 1.0.0
 */
public class MD5Uilts {

    /**
     *   MD5 加密
     * @param src  字符串字节数组
     * @return
     */
    public static String getMD5(byte[] src)throws NoSuchAlgorithmException{
        StringBuffer sb = new StringBuffer();
        //对字符进行加密处理
        try{
            //
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(src);
            for(byte b : md.digest()) {
                sb.append(Integer.toString(b >>> 4 & 0xF, 16)).append(Integer.toString(b & 0xF, 16));
            }
        }catch(NoSuchAlgorithmException e){
           throw e;
        }
        return sb.toString();
    }
}
