package com.concurrent.bootconcurrent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.concurrent.bootconcurrent.dao")
@EnableAsync
@EnableCaching
public class BootconcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootconcurrentApplication.class, args);
    }

}
