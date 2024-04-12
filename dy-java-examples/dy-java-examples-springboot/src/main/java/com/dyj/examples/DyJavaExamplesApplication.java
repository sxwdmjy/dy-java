package com.dyj.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author danmo
 * @date 2024-04-02 15:18
 **/
@ComponentScan(basePackages = "com.dyj.examples.**")
@SpringBootApplication
public class DyJavaExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DyJavaExamplesApplication.class, args);
        System.out.println("123");
    }
}
