package com.alpaca.admin.annotation;




import com.grace.commons.state.OperateType;

import java.lang.annotation.*;

/**
 * @ClassName: OperationLog
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/11 21:33
 * @Version: 1.0.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /** 要执行的操作类型比如：枚举值：ADD|UDP|DEL|LOGIN|OTHERS **/
    public OperateType operationType() default OperateType.OTHERS;

    /** 要执行的具体操作比如：添加用户 **/
    public String operationName() default "";

}
