package com.happy.javautil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class JavautilApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavautilApplication.class, args);
    }

}
