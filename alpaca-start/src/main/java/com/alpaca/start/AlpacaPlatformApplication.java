package com.alpaca.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

@ComponentScan(basePackages = {"com.alpaca"})
@MapperScan(basePackages = "com.alpaca.admin.mapper")
@EnableSwagger2
public class AlpacaPlatformApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
      //  SpringApplication.run(AlpacaPlatformApplication.class, args);
        ApplicationContext ctx =  SpringApplication.run(AlpacaPlatformApplication.class, args);

        String[] beanNames =  ctx.getBeanDefinitionNames();

        System.out.println("所以beanNames个数："+beanNames.length+"----------");

        for(String bean:beanNames){

            System.out.println(bean);

        }
        System.out.println("-------------------------------------");
    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AlpacaPlatformApplication.class);
    }
}
