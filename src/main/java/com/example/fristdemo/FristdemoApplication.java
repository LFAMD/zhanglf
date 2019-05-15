package com.example.fristdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fristdemo.mapper")
public class FristdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FristdemoApplication.class, args);
    }

}
