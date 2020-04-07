package com.feding.kesimpl.ums;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDubbo
@MapperScan(basePackages = "com.feding.kesimpl.ums.mapper")
@SpringBootApplication

public class KesimplUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesimplUmsApplication.class, args);
    }

}
