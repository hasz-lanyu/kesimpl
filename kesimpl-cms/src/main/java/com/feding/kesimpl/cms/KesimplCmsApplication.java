package com.feding.kesimpl.cms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@MapperScan("com.feding.kesimpl.cms.mapper")
@SpringBootApplication
public class KesimplCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesimplCmsApplication.class, args);
    }

}
