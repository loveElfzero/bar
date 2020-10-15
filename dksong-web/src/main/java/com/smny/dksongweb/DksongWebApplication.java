package com.smny.dksongweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.smny.dksongweb")
public class DksongWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DksongWebApplication.class, args);
    }

}
