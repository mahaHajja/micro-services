package com.sth.hotelsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableConfig
@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HotelsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelsServiceApplication.class, args);
    }

}
