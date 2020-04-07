package com.feding.kesimpl.admin;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableDubbo
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.feding.kesimpl.admin")
@EnableSwagger2
public class KesimplAdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesimplAdminWebApplication.class, args);
    }

}
