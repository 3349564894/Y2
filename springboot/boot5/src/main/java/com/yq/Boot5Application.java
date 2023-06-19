package com.yq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yq.mapper")
public class Boot5Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot5Application.class, args);
    }

}
