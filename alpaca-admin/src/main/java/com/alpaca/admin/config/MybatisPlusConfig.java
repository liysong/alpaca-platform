package com.alpaca.admin.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MybatisPlusConfig
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/3 23:45
 * @Version: 1.0.0
 */
@Configuration
@ComponentScan(basePackages = {"com.alpaca.admin.config"})
@MapperScan(basePackages = {"com.alpaca"},markerInterface = BaseMapper.class)
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
