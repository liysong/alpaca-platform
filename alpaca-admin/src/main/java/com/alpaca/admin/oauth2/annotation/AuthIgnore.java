package com.alpaca.admin.oauth2.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: AuthIgnore
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 19:05
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {
}
