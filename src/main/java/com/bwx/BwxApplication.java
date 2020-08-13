package com.bwx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.bwx"})
@MapperScan("com.bwx.mapper")
public class BwxApplication {

    public static void main(String[] args) {
        SpringApplication.run(BwxApplication.class, args);
    }
}
