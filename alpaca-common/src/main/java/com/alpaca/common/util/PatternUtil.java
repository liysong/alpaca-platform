package com.alpaca.common.util;

import com.alpaca.common.constant.RegexConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: PatternUtil
 * @Description: 正则表达式验证工具类
 * @Author：song
 * @Date: 2018/11/3 8:08
 * @Version: 1.0.0
 */
public class PatternUtil {

    /**
     * 验证email
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        return  isMatches(RegexConstant.EMAIL, email);
    }

    /**
     * 验证电话号码
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        return  isMatches(RegexConstant.PHONE_NUMBER, phone);
    }

    /**
     * 验证手机号码
     * @param mobile
     * @return
     */
    public static boolean checkMobile_(String mobile){
        return  isMatches(RegexConstant.MOBILE_NUMBER, mobile);
    }

    /**
     * 验证是否为整数
     * @param integer
     * @return
     */
    public static boolean checkInteger(String integer){
        return  isMatches(RegexConstant.INTEGER, integer);
    }

    /**
     * 正整数验证
     * @param integerNegative
     * @return
     */
    public static boolean checkIntegerNegative(String integerNegative){
        return  isMatches(RegexConstant.INTEGER_NEGATIVE, integerNegative);
    }

    /**
     * 负整数验证
     * @param integerPositive
     * @return
     */
    public static boolean checkIntegerPositive(String integerPositive){
        return  isMatches(RegexConstant.INTEGER_POSITIVE, integerPositive);
    }


    /**
     * 验证是否是double
     * @param doubleValue
     * @return
     */
    public static boolean checkDouble(String doubleValue){
        return  isMatches(RegexConstant.DOUBLE, doubleValue);
    }

    /**
     * 正Double 验证
     * @param doubleNegative
     * @return
     */
    public static boolean checkDoubleNegative(String doubleNegative){
        return  isMatches(RegexConstant.DOUBLE_NEGATIVE, doubleNegative);
    }

    /**
     * 负doule验证
     * @param doublePositive
     * @return
     */
    public static boolean checkDoublePositive (String doublePositive){
        return  isMatches(RegexConstant.DOUBLE_POSITIVE , doublePositive);
    }


    /**
     * 验证年龄是否合法,年龄匹配0-150岁
     * @param age
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkAge (String age){
        return  isMatches(RegexConstant.AGE , age);
    }



    /**
     * 国内6位邮编
     * @param postalCode
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPostalCode (String postalCode){
        return  isMatches(RegexConstant.POSTAL_CODE , postalCode);
    }


    /**
     * 只允许有中文
     * @param chineseUTF8
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChineseUTF8  (String chineseUTF8){
        return  isMatches(RegexConstant.POSTAL_CODE , chineseUTF8 );
    }


    /**
     * 验证特殊字符
     *  regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]";
     * @param str
     * @return 验证成功返回true，验证失败返回false
     */
    public static  boolean checkStrSpecial(String str){
        return  isMatches(RegexConstant.STR_SPECIAL,str);
    }

    /**
     * 验证URL地址
     * @param url 格式：http://xxx.aaa.:80/lgt1/article/details/7705960? 或 https://www.csdn.net:80 和 ftp://192.99.63:21/remotes
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkURL(String url) {

        return isMatches(RegexConstant.URL , url );
    }

    /**
     * 验证身份证号码
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */

    public static boolean checkIdCard  (String idCard){
        return  isMatches(RegexConstant.ID_CARD , idCard );
    }


    /**
     *  根据输入的正则表达式及输入值验证
     * @param regex   正则表达式
     * @param value 验证的值
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isMatches(String regex,String value){
        return Pattern.matches(regex, value);
    }

    /**
     * 获取正则匹配的部分
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return 正则匹配的部分
     */
    public static List<String> getMatches(String regex, CharSequence input) {
        if (input == null) return null;
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }


    /**
     * 获取正则匹配分组
     *
     * @param regex 正则表达式
     * @param input 要分组的字符串
     * @return 正则匹配分组
     */
    public static String[] getSplits(String regex , String input) {
        if (input == null) return null;
        return input.split(regex);
    }

    /**
     * 替换正则匹配的第一部分
     *
     * @param regex       正则表达式
     * @param input       要替换的字符串
     * @param replacement 代替者
     * @return 替换正则匹配的第一部分
     */
    public static String getReplaceFirst(String regex , String input, String replacement) {
        if (input == null) return null;
        return Pattern.compile(regex).matcher(input).replaceFirst(replacement);
    }

    /**
     * 替换所有正则匹配的部分
     *
     * @param regex       正则表达式
     * @param input       要替换的字符串
     * @param replacement 代替者
     * @return 替换所有正则匹配的部分
     */
    public static String getReplaceAll(String regex, String input, String replacement) {
        if (input == null) return null;
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }




}
