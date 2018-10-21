package com.mysiteforme.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mysiteforme.admin.dao")
public class MysiteformeApplication{
    public static void main(String[] args) {
        SpringApplication.run(MysiteformeApplication.class, args);
    }
}
