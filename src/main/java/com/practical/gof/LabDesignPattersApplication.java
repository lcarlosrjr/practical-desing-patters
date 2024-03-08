package com.practical.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabDesignPattersApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabDesignPattersApplication.class, args);
    }

}
