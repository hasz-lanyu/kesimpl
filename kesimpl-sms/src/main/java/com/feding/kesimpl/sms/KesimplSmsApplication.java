package com.feding.kesimpl.sms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@MapperScan("com.feding.kesimpl.sms.mapper")
@SpringBootApplication
public class KesimplSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesimplSmsApplication.class, args);
    }

}
