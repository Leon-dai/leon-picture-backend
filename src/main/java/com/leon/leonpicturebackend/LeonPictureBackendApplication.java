package com.leon.leonpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.leon.leonpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class LeonPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeonPictureBackendApplication.class, args);
    }

}
