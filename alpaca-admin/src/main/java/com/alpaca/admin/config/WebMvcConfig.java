package com.alpaca.admin.config;

import com.alpaca.admin.oauth2.interceptor.AuthorizationInterceptor;
import com.alpaca.admin.oauth2.resolver.LoginHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 10:12
 * @Version: 1.0.0
 */
@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private LoginHandlerMethodArgumentResolver loginHandlerMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/api/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginHandlerMethodArgumentResolver);
    }
}
