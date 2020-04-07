package com.feding.kesimpl.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDubbo
@MapperScan("com.feding.kesimpl.pms.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class KesimplPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesimplPmsApplication.class, args);
    }

}
