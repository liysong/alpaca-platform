package com.alpaca.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @Auther: song
 * @Date: 2018/11/8 11:08
 * @Description: 基于阿里巴巴 fastjson 包封装的json工具类
 * @Version:1.0.0
 */
public class FastJsonUtils {

    /**
     * 把JSON数据转换成指定的java对象
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T> T getJsonToBean(String jsonData,Class<T> clazz){
        return JSON.parseObject(jsonData,clazz);
    }

    /**
     * 功能描述：把java对象转换成JSON数据
     * @param object java对象
     * @return JSON数据
     */
    public static String getBeanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     * @param jsonData JSON数据
     * @param clazz 指定的java对象
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成较为复杂的List<Map<String, Object>>
     * @param jsonData JSON数据
     * @return List<Map<String, Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    /**
     * 把Json 转成指定类型的List<Map> 集合
     * @param jsonData
     * @param kvMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static  <K, V> List<Map<K, V>> getJsonToListMap2(String jsonData, TypeReference<List<Map<K, V>>> kvMap) {
        return JSON.parseObject(jsonData,kvMap);
    }

    /**
     * 将Map集合转换成字符串
     * @param m
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> String collectToString(Map<K, V> m) {
         return JSONObject.toJSONString(m);

    }


}
