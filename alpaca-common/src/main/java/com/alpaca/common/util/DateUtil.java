package com.alpaca.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/3 7:25
 * @Version: 1.0.0
 */
public class DateUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

  //  public static String DATE_FORMAT_CHINESE = "yyyy年M月d日";

    /**
     * 获取当前日期，格式为 yyyy-MM-dd
     * @return
     */
    public static String getCurrentDate() {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        dateStr = df.format(new Date());
        return dateStr;
    }

    /**
     * 获取当前日期时间，格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public  static  String  getCurrentDateTime(){
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        dateStr = df.format(new Date());
        return dateStr;
    }

    /**
     *  根据格式化参数获取当前日期或者时间
     * @param Dateformat
     * @return
     */
    public static String getCurrentDateTime(String Dateformat) {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(Dateformat);
        datestr = df.format(new Date());
        return datestr;
    }



    /**
     * 将字符串日期转换为日期格式
     * @param dateStr   日期字符串
     * @param dateFormat  格式化时间格式
     * @return
     */
    public static Date stringToDate(String dateStr, String dateFormat) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 根据时间转换成yyyy-MM-dd HH:mm:ss 字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        dateStr = df.format(date);
        return dateStr;
    }

    /**
     * 日期转换成字符串
     * 自定义转换格式
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToString(Date date, String dateFormat) {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        dateStr = df.format(date);
        return dateStr;
    }


}
